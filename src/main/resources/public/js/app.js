var callCenterCRM=angular.module("callCenterCRM",['ngRoute','restangular']);
callCenterCRM.config(function($routeProvider,$locationProvider){
    $locationProvider.html5Mode(true);
    $routeProvider
        .when('/', {
            templateUrl: 'views/index/main.html',
            controller: 'CustomerData'
        })
        .when('/customers.html', {
            templateUrl: 'views/customers/main.html'
        })
        .when('/users.html', {
            templateUrl: 'views/users/main.html'
        })
        .when('/campaigns.html', {
            templateUrl: 'views/campaigns/main.html'
        })
        .when('/diallist.html', {
            templateUrl: 'views/diallist/main.html'
        })
        .otherwise({
            redirectTo: '/'
        });
});