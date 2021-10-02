from django.db import models


class User(models.Model):
    phone_number = models.CharField(max_length=255, verbose_name='Номер телефона')

    class Meta:
        verbose_name = 'Пользователь'
        verbose_name_plural = 'Пользователи'

    def __str__(self):
        return self.phone_number


class CodeCheck(models.Model):
    user = models.ForeignKey(User, verbose_name='Пользователь', on_delete=models.CASCADE)
    code = models.IntegerField(verbose_name='Код')

    class Meta:
        verbose_name = 'Код'
        verbose_name_plural = 'Коды'

    def __str__(self):
        return self.user.phone_number


class CourseType(models.Model):
    title = models.CharField(max_length=255, verbose_name='Название')

    class Meta:
        verbose_name = 'Тип'
        verbose_name_plural = 'Типы'

    def __str__(self):
        return self.title


class Question(models.Model):
    type = models.ForeignKey(CourseType, verbose_name='Тип вопроса', on_delete=models.CASCADE)
    title = models.TextField(verbose_name='Текст вопроса')

    class Meta:
        verbose_name = 'Вопрос'
        verbose_name_plural = 'Вопросы'

    def __str__(self):
        return self.title


class Course(models.Model):
    type = models.ForeignKey(CourseType, on_delete=models.CASCADE, blank=True, null=True)
    title = models.CharField(max_length=255, verbose_name='Название')
    description = models.TextField(verbose_name='Описание', blank=True)
    address = models.CharField(max_length=255, verbose_name='Адрес')
    contact = models.CharField(max_length=255, verbose_name='Контакты', blank=True)
    longitude = models.CharField(max_length=255, verbose_name='Долгота')
    latitude = models.CharField(max_length=255, verbose_name='Широта')
    age_from = models.IntegerField(verbose_name='Возраст с')
    age_to = models.IntegerField(verbose_name='Возраст до')
    price = models.IntegerField(verbose_name='Цена')
    image_url = models.CharField(max_length=255, verbose_name='Картинка', blank=True)

    class Meta:
        verbose_name = 'Кружок'
        verbose_name_plural = 'Кружки'

    def __str__(self):
        return self.title
