from django.shortcuts import redirect, render
from django.contrib.auth.decorators import login_required
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.models import User

from web.forms import UserLoginForm

# Create your views here.
def home(request):
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
    return render(request, 'index.html', context)