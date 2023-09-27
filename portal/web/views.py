from django.shortcuts import redirect, render
from django.contrib.auth.decorators import login_required
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.models import User

from web.forms import UserLoginForm, UserRegistrationForm

import pymssql 


# Create your views here.
@login_required
def home(request):
    next = request.GET.get('next')

    # connect to the db
    server = '10.4.115.115'
    database = 'Integrator'
    user = 'Integration'
    password = 'NoLies#23'

    conn = pymssql.connect(server, user, password, database)
    cursor = conn.cursor(as_dict=True)
    fields = []

    cursor.execute('SELECT * FROM icea_request_validation')
    print(cursor)
    for row in cursor:
        fields.append(row)
        print("ID=%d, policy_number=%s" % (row['id'], row['policy_number']))

    conn.close()
    context = {
        'fields': fields,
    }

    return render(request, 'index.html', context=context)

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