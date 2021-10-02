import random
import requests

from django.core.exceptions import ObjectDoesNotExist
from django.http import JsonResponse
from rest_framework.views import APIView, Response
from django.core import serializers
from . import models
from . import serializers


def send_sms(number, password):
    message = f"Ваш пароль:\n{password}"
    a = requests.post('https://smsc.ru/sys/send.php',
                      params=dict(
                          login='urmipie',
                          psw='send_sms',
                          phones=number,
                          mes=message)
                      )


class UserView(APIView):
    def post(self, request):
        data = request.data
        try:
            user = models.User.objects.get(phone_number=data['phone_number'])
        except ObjectDoesNotExist:
            user = models.User(
                phone_number=data['phone_number']
            )
            user.save()
        code = models.CodeCheck(
            user=user,
            code=random.randint(10000, 99999)
        )
        code.save()
        send_sms(data['phone_number'], code.code)
        return Response({
            'code': code.code
        })


class CourseView(APIView):
    def get(self, _):
        data = list(models.Course.objects.values())
        return JsonResponse(data, safe=False)

    def post(self, request):
        courses = request.data
        s = serializers.CourseSerializer(data=courses, many=True)
        if s.is_valid():
            s.save()
            return Response(s.data)
        return Response({'data': 'data'})


class QuestionView(APIView):
    def post(self, _):
        data = list(models.Question.objects.values())
        return JsonResponse(data, safe=False)


class FilterView(APIView):
    def get(self, request):
        data = request.data
        types, count = data['types'], data['count']

        courses = []
        for t in types:
            percent = (t['count'] / count) * 100
            type = models.CourseType.objects.get(id=t['type_id'])
            if percent > 50:
                c = models.Course.objects.filter(type=type).values()
                courses.extend(list(c))
        return Response(courses)
