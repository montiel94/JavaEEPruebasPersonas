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

  function loginCtrl($scope, $location, $rootScope,$timeout,ServicioLogin,ModalService)
{
    var view = $scope;
    view.accionBtnAceptar = accionBtnAceptar;
    view.showComplex = showComplex;
    $scope.showError = false;
    $scope.doFade = false;



     function showComplex ()  {
         console.log('entrado al metodo showComplex');
            if (validaCampos()) {
                /*ModalService.showModal({
                    templateUrl: "scripts/controllers/login/modalLogin/complex.html",
                    controller: "ComplexController",

                    inputs: {
                        title: "Usuario bloqueado"
                    }
                }).then(function (modal) {
                    modal.element.modal();
                    modal.close.then(function (result) {
                        console.log('resultado : '+ result.exito);
                    });
                });
                console.log('el estado de la operacion fue : ' + $scope.exitoDesbloqueoUsuario);*/
                ServicioLogin.validarUsuarioBloqueado(view.user,view.password)
                    .then(function(data){
                        console.log('usuario apto para hacer desbloqueo');
                        var error = data;
                    })
                    .catch(function (error) {
                        console.log('se produjo un error en la validacion de desbloqueo');
                        $scope.showError = false;
                        $scope.doFade = false;
                        $scope.showError = true;
                        $scope.errorMessage = error;
                        $timeout(function(){
                            $scope.doFade = true;
                        }, 2500);

                    });

            }
            console.log('saliendo de el metodo showComplex')

    };
     
     function validaCampos() {
         console.log('entrando a la funcion validaCampos');
         var regEx = /^[a-z0-9]+$/i;
         if (!view.user) {
             mostrarError('El campo correo electronico es obligatorio');
             return false;
         }
         if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(view.user))
         {
             mostrarError('Correo electronico no cumple con formato');
             return false;
         }
         if (!view.password)
         {
             mostrarError('El campo contraseña es obligatorio')
             return false;
         }
         if (!/^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$/.test(view.password))
         {
             mostrarError('El campo contraseña no cumple con formato');
             return false;
         }
         return true;
         console.log('saliendo de la funcion validaCampos');
     }

     function mostrarError(error) {
         console.log('entrando al metodo mostrarError');
         $scope.showError = false;
         $scope.doFade = false;
         $scope.showError = true;
         $scope.errorMessage = error;
         $timeout(function(){
             $scope.doFade = true;
         }, 2500);
         console.log('saliendo de la funcion mostrarError');
     }

    function accionBtnAceptar()
    {
        console.log('entrando a : function accionBtnAceptar controlador');
        if (validaCampos())
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

