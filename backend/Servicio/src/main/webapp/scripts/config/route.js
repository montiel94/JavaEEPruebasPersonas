/**
 * Created by Daniel jose on 02/02/2017.
 */
'use strict';

/**
 * @ngdoc overview
 * @name webAppVtrackApp
 * @description
 * # webAppVtrackApp
 *
 * Main module of the application.
 */
angular
    .module('webAppVtrackApp', [
        'ngAnimate',
        'ngCookies',
        'ngResource',
        'ngRoute',
        'ngSanitize',
        'ngTouch',
        'ngMessages',
        'ngMessage',
        'ui.bootstrap',
        'webAppVtrackApp.services',
        'webAppVtrackApp.ModalService'
    ]).constant("BASE_URL", "http://localhost:8080/webservice.servicio/api")
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/login/login.html',
                controller: 'LoginctrlCtrl',
                controllerAs: 'main'
            })
            .when('/Dashboard', {
                templateUrl: 'views/dashboard/dashboard.html',
                controller: 'MasterCtrl'
            })
            .otherwise({
                redirectTo: '/Dashboard'
            });
    });
