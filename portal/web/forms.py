from django.forms import ModelForm
from django import forms
from django.contrib.auth import authenticate, get_user_model

User = get_user_model()

class UserLoginForm(forms.Form):
    username = forms.CharField(max_length=200)
    password = forms.CharField(widget=forms.PasswordInput)

    def clean(self, *args, **kwargs):
        username = self.cleaned_data.get('username')
        password = self.cleaned_data.get('password')
        user = User.objects.filter(username=username)
        if not user:
            raise forms.ValidationError("This user does not exist")
        elif username and password:
            user = authenticate(username=username, password=password)
            if not user:
                raise forms.ValidationError("Incorrect Credentials")
            if not user.is_active:
                raise forms.ValidationError("User is not Active")

        return super(UserLoginForm, self).clean(*args, **kwargs)
    

class UserRegistrationForm(forms.Form):
    username = forms.CharField(max_length=150)
    email = forms.EmailField()
    password = forms.CharField(widget=forms.PasswordInput)
    confirm_password = forms.CharField(widget=forms.PasswordInput)

    def clean(self, *args, **kwargs):
        email = self.cleaned_data.get('email')
        username = self.cleaned_data.get('username')
        password = self.cleaned_data.get('password')
        confirm_password = self.cleaned_data.get('confirm_password')

        if password != confirm_password:
            raise forms.ValidationError("The 2 Passwords Do Not Match")
        users = User.objects.all()
        username_qs = users.filter(username=username)
        if username_qs:
            raise forms.ValidationError("This username is taken")
        email_qs = users.filter(email=email)
        if email_qs:
            raise forms.ValidationError("This email is already registered")

        return super(UserRegistrationForm, self).clean(*args, **kwargs)