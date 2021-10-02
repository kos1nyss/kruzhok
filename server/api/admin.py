from django.contrib import admin
from . import models


@admin.register(models.CodeCheck)
class CodeCheckAdmin(admin.ModelAdmin):
    list_display = ('user', 'code',)


@admin.register(models.User)
class UserAdmin(admin.ModelAdmin):
    list_display = ('phone_number',)


@admin.register(models.CourseType)
class CourseTypeAdmin(admin.ModelAdmin):
    list_display = ('id', 'title',)


@admin.register(models.Question)
class QuestionAdmin(admin.ModelAdmin):
    list_display = ('type', 'title',)


@admin.register(models.Course)
class CourseAdmin(admin.ModelAdmin):
    list_display = ('type', 'title', 'address')
