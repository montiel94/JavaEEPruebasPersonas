angular.module('webAppVtrackApp')
    .controller('ComplexController', ComplexControllerCtrl);


    function ComplexControllerCtrl ($scope, $element, title, close,$timeout,ServicioLogin) {

        var view = $scope;
        $scope.title = title;
        $scope.valorBoton = 1;
        $scope.exitoDesbloqueoUsuario = null;

        //  This close function doesn't need to use jQuery or bootstrap, because
        //  the button has the 'data-dismiss' attribute.
        $scope.close = function() {
            close({
                exito : '2'
            }, 500); // close, but give 500ms for bootstrap to animate
        };

        //  This cancel function must use the bootstrap, 'modal' function because
        //  the doesn't have the 'data-dismiss' attribute.
        $scope.cancel = function() {

            //  Manually hide the modal.
            $element.modal('hide');

        };
        /*
            funcion que llama al servicio rest para hacer el cambio de contrasena
         */
        $scope.cambiarPassword = function (){
            console.log('entrando a la funcion validarUsuario');
            if (validarPassword())
            {
                ServicioLogin.modificarContrasenaUsuario($scope.correoUsuario,view.password)
                    .then(function(data){
                        console.log('usuario apto para hacer desbloqueo');
                        var error = data;
                        //$scope.exitoDesbloqueoUsuario = '1';
                        $element.modal('hide');
                        close({
                            exito : '1'
                        }, 500);


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

            console.log('saliendo de la funcion validarUsuario');
        }
        /*
            funcion que valida todos los campos de cambio de contrasena
         */
        function validarPassword() {
            console.log('entrando al metodo validar');
            if (!view.password)
            {
                mostrarError('El campo contraseña es obligatorio')
                return false;
            }
            if (!view.passwordConfirmacion)
            {
                mostrarError('El campo confirmación de contraseña es obligatorio')
                return false;
            }
            if (!/^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$/.test(view.password)
                && (view.password.length>=6))
            {
                mostrarError('El campo contraseña no cumple con requisitos')
                return false;
            }
            if (!/^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$/.test(view.passwordConfirmacion)
                && (view.passwordConfirmacion.length>=6))
            {
                mostrarError('El campo confirmación de contraseña no cumple con requisitos')
                return false;
            }
            if (view.password != view.passwordConfirmacion)
            {
                mostrarError('La constraseña y su confirmación son distintos');
                return false;
            }
            return true;
            console.log('saliendo del validar validar');
        }
        /*
            funcion que muestra el mensaje de error
         */
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