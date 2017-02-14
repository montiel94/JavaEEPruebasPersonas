/**
 * Created by Daniel jose on 03/02/2017.
 */
/**
 * Created by Daniel jose on 03/02/2017.
 */
'use strict';
angular.module('webAppVtrackApp.services')
    .service('ServicioLogin', ['$q','$rootScope','$http','BASE_URL',ServicioLogin]);

function ServicioLogin($q,$rootScope,$http,BASE_URL)
{
    this.login = login;
    this.validarUsuarioBloqueado = validarUsuarioBloqueado;

    function validarUsuarioBloqueado(login,password) {
        console.log('entrando al metodo validarUsuarioBloqueado');
        var defered = $q.defer();
        var promise = defered.promise;
        var usuario = {"username": login,"password": password};
        console.log('saliendo del metodo validarUsuarioBloqueado');
        $http
        ({
            method: 'post',
            url: BASE_URL + '/usuario/password',
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(usuario)
        }).then(function success(response)
        {
            //console.log(response);
            //defered.resolve(response.data);
        },function error(response)
        {
            //console.log('error: '+response);
            //var error = response.data;
            //defered.reject(error.mensaje);
        });

        return promise;

    }

    function login(login,password) {
        var defered = $q.defer();
        var promise = defered.promise;
        console.log('entrando a : function login de ServicioLogin');
        var usuario = {"username": login,"password": password};
        $http
        ({
            method: 'post',
            url: BASE_URL + '/auth/token',
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(usuario)
        }).then(function success(response)
        {
            console.log(response);
            defered.resolve(response.data);
        },function error(response)
        {
            console.log('error: '+response);
            var error = response.data;
            defered.reject(error.mensaje);
        });

        return promise;
    }
}


