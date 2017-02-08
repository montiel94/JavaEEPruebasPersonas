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

  function loginCtrl($scope, $location, $rootScope,$timeout,ServicioLogin)
{
    var view = $scope;
    view.accionBtnAceptar = accionBtnAceptar;
    $scope.showError = false;
    $scope.doFade = false;
    function accionBtnAceptar()
    {
        console.log('entrando a : function accionBtnAceptar controlador');
        if (view.user.length>0 && view.password.length>0)
        {
        	ServicioLogin.login(view.user,view.password)
                .then(function(data){
                    console.log('se realizo login exitosamente');
                    var error = data;
                })
                .catch(function (error) {
                    console.log('se produjo un error en el login');
                    $scope.showError = false;
                    $scope.doFade = false;
                    $scope.showError = true;
                    $scope.errorMessage = error;
                    $timeout(function(){
                        $scope.doFade = true;
                    }, 2500);

                });
        }
        console.log('saliendo de : function accionBtnAceptar controlador');
    }
    
}

