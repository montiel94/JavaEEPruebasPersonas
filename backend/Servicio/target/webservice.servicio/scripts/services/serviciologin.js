/**
 * Created by Daniel jose on 03/02/2017.
 */
/**
 * Created by Daniel jose on 03/02/2017.
 */
'use strict';
angular.module('webAppVtrackApp.services')
    .service('ServicioLogin', ['$q','$rootScope','$http','BASE_URL',ServicioLogin]);

function ServicioLogin($q,$rootScope,$http,BASE_URL,$scope)
{
    this.login = login;
    this.validarUsuarioBloqueado = validarUsuarioBloqueado;
    this.modificarContrasenaUsuario = modificarContrasenaUsuario;
    this.olvidasteContrasena = olvidasteContrasena;
    this.validarUsuarioBloqueado = validarUsuarioBloqueado;
    this.validarAutoregistro = validarAutoregistro;
    this.autoregistro = autoregistro;
    this.getToken = getToken;
    /*
         metodo encargado de terminar el proceso de autoregistro
         parametros
         login : correo de cliente
         password : contrasena del cliente
     */
    function autoregistro (login,password){
        console.log('entrando a la funcion autoregistro');
        var defered = $q.defer();
        var promise = defered.promise;
        var usuario = {"username": login,"password": password};
        $http
        ({
            method: 'put',
            url: BASE_URL + '/usuario/autoRegistro',
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
        console.log('saliendo de la funcion autoregistro');
    }


    /*
        metodo llamado en el metodo cuando el usuario olvido contrasena
        se envia contrasena
     */
    function olvidasteContrasena(login) {
        console.log('entrando al metodo olvidasteContrasena');
        var defered = $q.defer();
        var promise = defered.promise;
        var usuario = {"username": login,"password": null};
        $http
        ({
            method: 'post',
            url: BASE_URL + '/usuario/olvidastecontrasena',
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
        console.log('saliendo del metodo olvidasteContrasena');
    }

    /*
        funcion que llama al servicio REST para modificar la contrasena
        de un usuario
     */
    function modificarContrasenaUsuario(login,password) {
        console.log('entrando al metodo modificarContrasenaUsuario');
        var defered = $q.defer();
        var promise = defered.promise;
        var usuario = {"username": $rootScope.correoUsuario,"password": password};
        console.log('saliendo del metodo validarUsuarioBloqueado');
        $http
        ({
            method: 'put',
            url: BASE_URL + '/usuario/password',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + $rootScope.token
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
        console.log('entrando al metodo modificarContrasenaUsuario');
    }
    /*
        funcion que consulta servicio REST para saber si esta bloqueado
     */
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

    /*
     funcion que pide acceso al sistema
     */
    function getToken(CodigoToken) {
        var defered = $q.defer();
        var promise = defered.promise;
        console.log('entrando a : function login de ServicioLogin');
        //var CodigoToken = {"valor": auth,"tipo": "TOKEN"};
        $http
        ({
            method: 'put',
            url: BASE_URL + '/auth/token',
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(CodigoToken)
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
    /*
        funcion que pide acceso al sistema
     */
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

    function validarAutoregistro(login) {
        console.log('entrando a la funcion validarAutoregistro');
        var defered = $q.defer();
        var promise = defered.promise;
        var usuario = {"username": login,"password": null};
        $http
        ({
            method: 'post',
            url: BASE_URL + '/usuario/autoRegistro',
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
        console.log('saliendo de la funcion validarAutoregistro');

    }
}


