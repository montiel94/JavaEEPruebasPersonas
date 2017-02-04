/**
 * Created by Daniel jose on 03/02/2017.
 */
/**
 * Created by Daniel jose on 03/02/2017.
 */
'use strict';
angular.module('webAppVtrackApp.services')
    .service('ServicioLogin', ServicioLogin);

function ServicioLogin($rootScope,$http,BASE_URL)
{
    this.login = login;

    function login(login,password) {

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

        })
    }
}


