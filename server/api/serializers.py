from rest_framework import serializers
from . import models


class CourseSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Course
        fields = ('title', 'description', 'address', 'longitude', 'latitude', 'age_from', 'age_to', 'price', 'contact',
                  'image_url')
