angular.module('webAppVtrackApp')
    .controller('ComplexController', ComplexControllerCtrl);


    function ComplexControllerCtrl ($scope, $element, title, close,$timeout) {


        $scope.title = title;
        $scope.valorBoton = 1;
        $scope.exitoDesbloqueoUsuario = null;

        //  This close function doesn't need to use jQuery or bootstrap, because
        //  the button has the 'data-dismiss' attribute.
        $scope.close = function() {
            close({
                exito : '1'
            }, 500); // close, but give 500ms for bootstrap to animate
        };

        //  This cancel function must use the bootstrap, 'modal' function because
        //  the doesn't have the 'data-dismiss' attribute.
        $scope.cancel = function() {

            //  Manually hide the modal.
            $element.modal('hide');

        };

        $scope.cambiarPassword = function (){
            console.log('entrando a la funcion validarUsuario');
            if (validarPassword())
            {
                
            }
            $scope.exitoDesbloqueoUsuario = '1';
            close({
                exito : '1'
            }, 500);
            $element.modal('hide');
            console.log('saliendo de la funcion validarUsuario');
        }
        
        function validarPassword() {
            console.log('entrando al metodo validar');
            mostrarError('contrasenas no cumplen con requisitos');
            console.log('saliendo del validar validar');
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


    }