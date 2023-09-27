from django.shortcuts import redirect, render
from django.contrib.auth.decorators import login_required
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.models import User

from web.forms import UserLoginForm, UserRegistrationForm

# Create your views here.
@login_required
def home(request):
    next = request.GET.get('next')
    return render(request, 'index.html')

def signup(request):
    signup = UserRegistrationForm(request.POST or None)
    # signup = UserRegistrationForm(request.POST or None)
    if signup.is_valid():
        username = signup.cleaned_data.get('username')
        email = signup.cleaned_data.get('email')
        password = signup.cleaned_data.get('password')

        user = User.objects.create_user(username=username, email=email, password=password)
        user.save()
        authenticate(username=user.username, password=user.password)
        login(request, user)
        instance = User.objects.get(id=user.id)
        return redirect(home)
    
    context = {
        'signup': signup,
    }
    return render(request, 'signup.html', context)

def log_in(request):
    next = request.GET.get('next')
    # login form
    log_in = UserLoginForm(request.POST or None)
    if log_in.is_valid():
        username = log_in.cleaned_data.get('username')
        password = log_in.cleaned_data.get('password')
        user = authenticate(username=username, password=password)
        login(request, user)
        if next:
            redirect(next)
        return redirect('home')
    
    context = {
        'log_in': log_in,
    }
    return render(request, 'login.html', context)


@login_required
def log_out(request):
    logout(request)
    return redirect('/')