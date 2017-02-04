'use strict';

/**
 * @ngdoc function
 * @name webAppVtrackApp.controller:LoginctrlCtrl
 * @description
 * # LoginctrlCtrl
 * Controller of the webAppVtrackApp
 */
angular.module('webAppVtrackApp')
  .controller('LoginctrlCtrl', loginCtrl);

  function loginCtrl($scope, $location, $rootScope,ServicioLogin)
{
    var view = $scope;
    view.accionBtnAceptar = accionBtnAceptar;

    function accionBtnAceptar()
    {
        console.log('entrando a : function accionBtnAceptar controlador');
        if (view.user.length>0 && view.password.length>0)
        {
        	ServicioLogin.login(view.user,view.password);
        }
        console.log('saliendo de : function accionBtnAceptar controlador');
    }
    
}

