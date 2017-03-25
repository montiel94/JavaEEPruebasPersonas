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
        'webAppVtrackApp.ModalService',
        'ui.router',
    ]).constant("BASE_URL", "http://localhost:8080/webservice.servicio/api")
    .config(function ($stateProvider, $urlRouterProvider) {

        $stateProvider
        // HOME STATES AND NESTED VIEWS ========================================
            .state('dashboardpedidos', {
                url: '/dashboard',
                //templateUrl: 'views/dashboard/dashboard.html',
                //controller: 'MasterCtrl',
                views: {
                    '':{
                        templateUrl: 'views/dashboard/dashboard.html',
                        controller: 'MasterCtrl'
                    },
                    'pedidosGeneral@dashboardpedidos':{
                        templateUrl: 'views/dashboard/pedidosTemplate.html',
                        controller: 'PedidosCtrl'
                    }
                }
            })
            .state('dashboardgenerarpedido', {
                url: '/dashboardgenerarpedido',
                //templateUrl: 'views/dashboard/dashboard.html',
                //controller: 'MasterCtrl',
                views: {
                    '':{
                        templateUrl: 'views/dashboard/dashboard.html',
                        controller: 'MasterCtrl'
                    },
                    'SolicitarPedido@dashboardgenerarpedido':{
                        templateUrl: 'views/dashboard/solicitarPedidoTemplate.html'
                    }
                }
            })
            .state('dashboarddetalladopedido', {
                url: '/dashboarddetalladopedido',
                //templateUrl: 'views/dashboard/dashboard.html',
                //controller: 'MasterCtrl',
                views: {
                    '':{
                        templateUrl: 'views/dashboard/dashboard.html',
                        controller: 'MasterCtrl'
                    },
                    'Detalladopedido@dashboarddetalladopedido':{
                        templateUrl: 'views/dashboard/detalladoPedidoTemplate.html',
                        controller:'DetalladoPedidoCtrl'
                    }
                }
            })
            .state('perfil',{
                url: '/perfil',
                views: {
                    '': {
                        templateUrl: 'views/dashboard/dashboard.html',
                        controller: 'MasterCtrl'
                    },
                    'perfil@perfil': {
                        templateUrl: 'views/dashboard/perfilTemplate.html',
                        controller: 'PerfilCtrl'
                    }
                }
            })
            .state('login', {
                url: '/login',
                templateUrl: 'views/login/login.html',
                controller: 'LoginctrlCtrl',
            });

        $urlRouterProvider.otherwise('/login');
    });
