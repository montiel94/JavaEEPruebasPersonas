'use strict';

/**
 * @ngdoc function
 * @name webAppVtrackApp.controller:LoginctrlCtrl
 * @description
 * # LoginctrlCtrl
 * Controller of the webAppVtrackApp
 */
angular.module('webAppVtrackApp')
  .controller('LoginctrlCtrl',['$scope', '$location', '$rootScope','$timeout','ServicioLogin','ModalService','$state',loginCtrl]);

  function loginCtrl($scope, $location, $rootScope,$timeout,ServicioLogin,ModalService,$state)
{
    var view = $scope;
    view.accionBotonOlvidasteContrasena = accionBotonOlvidasteContrasena;
    view.accionBtnAceptar = accionBtnAceptar;
    view.accionBotonUsuarioBloqueado  = accionBotonUsuarioBloqueado ;
    view.accionBtnAutoRegistro = accionBtnAutoRegistro;
    $scope.showError = false;
    $scope.doFade = false;


    /*
        metodo que baja el modal de boton :
        tu usuario se encuentra bloqueado?
     */
    function showModal() {
        console.log('entrando al metodo show modal');
        ModalService.showModal({
            templateUrl: "scripts/controllers/login/modalLogin/complex.html",
            controller: "ComplexController",

            inputs: {
                title: "Usuario bloqueado"
            }
        }).then(function (modal) {
            modal.element.modal();
            modal.close.then(function (result) {
                console.log('resultado : '+ result.exito);
                if (result.exito == 1)
                {
                    mostrarSucces('Tu contrasena fue modificada con exito');
                }
            });
        });
        console.log('saliendo del metodo show modal');
    }
    
    function showModalAutoregistro() {
        console.log('entrando a la funcion showModalAutoregistro');
        ModalService.showModal({
            templateUrl: "views/login/modalAutoregistroUsuario.html",
            controller: "autoregistrousuariocontroller",

            inputs: {
                title: "Autoregistro de usuario"
            }
        }).then(function (modal) {
            modal.element.modal();
            modal.close.then(function (result) {
                console.log('resultado : '+ result.exito);
               if (result.exito == 1)
                {
                    mostrarSucces('Tu usuario fue autoregistrado con exito');
                }
            });
        });
        console.log('saliendo de la funcion showModalAutoregistro');
    }
    
    /*
        funcion que baja el modal de olvidaste tu contrasena
     */
    function showModalOlvidasteContrasena() {
        console.log('entrando a la funcion showModalOlvidasteContrasena');
        ModalService.showModal({
            templateUrl: "views/login/modalOlvidasteContrasena.html",
            controller: "olvidastecontrasenamodalcontroller",
            inputs: {
                title: "Olvidaste contraseña"
            }
        }).then (function (modal) {
            modal.element.modal();
            modal.close.then(function (result) {
                console.log('exito modal');
                if (result.exito == 1)
                {
                    mostrarSucces('Se envió una contraseña provisional al correo registrado');
                }
            });
        });
        console.log('saliendo de la funcion showModalOlvidasteContrasena');
    }

    /*
        metodo llamado cuando el usuario da click al boton :
        olvidaste tu contrasena?
     */
    function accionBotonOlvidasteContrasena()
    {
        console.log('entrando al metodo accionBotonOlvidasteContrasena');
        showModalOlvidasteContrasena();
        console.log('saliendo del metodo accionBotonOlvidasteContrasena');
    }

    /*
        metodo llamado cuando el usuario da click al boton :
        tu usuario se encuentra bloqueado?
     */
     function accionBotonUsuarioBloqueado ()  {
         console.log('entrado al metodo showComplex');
            if (validaCampos()) {
                ServicioLogin.validarUsuarioBloqueado(view.user,view.password)
                    .then(function(data){
                        console.log('usuario apto para hacer desbloqueo');
                        var error = data;
                        $rootScope.token = data.valor;
                        $rootScope.correoUsuario = view.user;
                        console.log('Token recibido : ' + $scope.token);
                        showModal();
                    })
                    .catch(function (error) {
                        console.log('se produjo un error en la validacion de desbloqueo');
                        mostrarError(error);
                    });

            }
            console.log('saliendo de el metodo showComplex')

    };
     /*
          funcion que valida los campos de correo electronico y
          contresena, devuelve false en caso que uno de los input
          no cumpla con condicion
          true en caso de que todos los inputs cumplan
      */
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
             mostrarError('El campo contraseña es obligatorio');
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
    /*
        funcion que quita class al div de error
     */
     function limpiarZonaError() {
         var zonaLimpiar = angular.element(document.querySelector( '#zonaerror' ));
         zonaLimpiar.removeClass('alert alert-danger');
         zonaLimpiar.removeClass('alert alert-success');
     }
     /*
        funcion que muentra mensaje de error
      */
     function mostrarError(error) {
         console.log('entrando al metodo mostrarError');
         limpiarZonaError();
         var zonaError = angular.element(document.querySelector( '#zonaerror' ));
         zonaError.addClass('alert alert-danger');
         $scope.showError = false;
         $scope.doFade = false;
         $scope.showError = true;
         $scope.errorMessage = error;
         $timeout(function(){
             $scope.doFade = true;
         }, 2500);
         console.log('saliendo de la funcion mostrarError');
     }


    /*
     funcion que muestra el mensaje de success
     */
    function mostrarSucces(error) {
        limpiarZonaError();
        var zonaError = angular.element(document.querySelector( '#zonaerror' ));
        zonaError.addClass('alert alert-success');
        $scope.showError = false;
        $scope.doFade = false;
        $scope.showError = true;
        $scope.errorMessage = error;
        $timeout(function(){
            $scope.doFade = true;
        }, 2500);
    }
    /*
        funcion que se ejecuta al presionar el boton de auto registro
     */
    function  accionBtnAutoRegistro()
    {
        console.log('entrando al metodo accionBtnAutoRegistro');
        //showModalAutoregistro();
        if (validaCampos())
        {
            ServicioLogin.validarUsuarioNuevo(view.user,view.password)
                .then(function(data){
                    console.log('se realizo consulta  exitosamente');
                    console.log('bajar modal');
                    ServicioLogin.setusuarioAutoRegistro(view.user)
                    showModalAutoregistro();
                })
                .catch(function (error) {
                    console.log('se produjo un error en el login');
                    mostrarError(error);
                });
        }
        console.log('entrando al metodo accionBtnAutoRegistro');
    }
    /*
        funcion que se utiliza cuando el usuario intenta ingresar en el sistema
     */
    function accionBtnAceptar()
    {
        console.log('entrando a : function accionBtnAceptar controlador');
        if (validaCampos())
        {
            var authsucess = "";
        	ServicioLogin.login(view.user,view.password)
                .then(function(data){
                    console.log('se realizo login exitosamente');
                    var error = data;
                    var authsucess =  data.valor;
                    authRecibidoSolicitarToken(data);
                })
                .catch(function (error) {
                    console.log('se produjo un error en el login');
                    mostrarError(error);

                });

        }
        console.log('saliendo de : function accionBtnAceptar controlador');
    }

    function authRecibidoSolicitarToken(auth) {
        console.log('entrando al metodo authRecibidoSolicitarToken');
        ServicioLogin.getToken(auth)
            .then(function(data){
                console.log('se realizo login exitosamente');
                var error = data;
                $rootScope.tokenAuth = data.valor;
                $rootScope.correouser = view.user;
                $state.go( 'dashboardpedidos' );
            })
            .catch(function (error) {
                console.log('se produjo un error en el login');
                mostrarError(error);
            });
        console.log('saliendo del metodo authRecibidoSolicitarToken');
    }

}

