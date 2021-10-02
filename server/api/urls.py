from django.urls import path
from . import views

urlpatterns = [
    path('user/', views.UserView.as_view()),
    path('course/', views.CourseView.as_view()),
    path('questions/', views.QuestionView.as_view()),
    path('filter/', views.FilterView.as_view())
]
