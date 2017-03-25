/**
 * Created by Daniel jose on 21/03/2017.
 */
angular.module('webAppVtrackApp')
    .controller('PerfilCtrl', ['$scope', '$location', '$rootScope','$state','ServicioPerfil','ModalService','$timeout',PerfilCtrl]);

function PerfilCtrl($scope, $location, $rootScope,$state,ServicioPerfil,ModalService,$timeout)
{
    var modoDebug = true;


    function pintarInformacion(data) {
        console.log('entrando al metodo pintarInformacion');
        var divTitulo =
            angular.element(document.querySelector('#divtitulo'));
        divTitulo.append(data.nombreempresa);
        var divNombre =
            angular.element(document.querySelector('#divnombre'));
        divNombre.append(data.nombreempresa);
        var divCorreo =
            angular.element(document.querySelector('#divcorreo'));
        divCorreo.append(data.username);
        var divEstado =
            angular.element(document.querySelector('#divestado'));
        divEstado.append(data.estadoUsuario);
        console.log('saliendo del metodo pintarInformacion');
    }

    $scope.init =  function()
    {
        console.log('entrando al metodo init');
        if (angular.isUndefined($rootScope.tokenAuth)) {
            $state.go('login');
        }
        else {
            if (modoDebug == true) {
                console.log('modoDebug activado');
                ServicioPerfil.getUsuario($rootScope.correouser)
                    .then(function(data){
                        console.log('se hizo correctamente llamada al servicio rest');
                        pintarInformacion(data);

                    })
                    .catch(function (error) {
                        console.log('se produjo un error llamando al servicio rest');
                        $state.go( 'login' );
                    });
            }
            else {

                console.log('modoDebug Desactivado');
            }
        }
        console.log('saliendo del mtodo init');
    };

    $scope.bajarModalModificarContrasena =  function () {
        console.log('entrando a la funcion bajarModalModificarContrasena');
        ModalService.showModal({
            templateUrl: "views/dashboard/modalCambiarContrasenaTemplate.html",
            controller: "PerfilCambiarContrasenaCtrl",
            inputs: {
                title: "Modificar contraseña"
            }
        }).then (function (modal) {
            modal.element.modal();
            modal.close.then(function (result) {
                console.log('exito modal');
                if (result.exito == 1)
                {
                    mostrarSucces('Tu contraseña fue modificada con exito');
                }
            });
        });
        console.log('saliendo de la funcion bajarModalModificarContrasena');
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

}
