/**
 * Created by Daniel jose on 22/02/2017.
 */
angular.module('webAppVtrackApp')
    .controller('autoregistrousuariocontroller', autoregistrousuariocontroller);


function autoregistrousuariocontroller ($scope, $element, title, close,$timeout,ServicioLogin,$compile) {

    var view = $scope;
    $scope.title = title;
    $scope.valorBoton = 1;


    //  This cancel function must use the bootstrap, 'modal' function because
    //  the doesn't have the 'data-dismiss' attribute.
    $scope.cancel = function() {

        //  Manually hide the modal.
        $element.modal('hide');

    };

    function validarContrasena() {
        console.log('entrando al metodo validarContrasena');
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
            || (view.password.length<6))
        {
            mostrarError('El campo contraseña no cumple con requisitos')
            return false;
        }
        if (!/^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$/.test(view.passwordConfirmacion)
            || (view.passwordConfirmacion.length<6))
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
        console.log('entrando al metodo validarContrasena');
    }
    $scope.accionBotonOk = function (){
        console.log('entrando a la funcion accionBotonOk');

        if (validarContrasena())
        {
            ServicioLogin.autoregistro(view.correoEmpresa,view.password)
                .then(function(data){
                    console.log('se realizo login exitosamente');
                    var error = data;
                    $element.modal('hide');
                    close({
                        exito : '1'
                    }, 500);
                })
                .catch(function (error) {
                    console.log('se produjo un error en el login');
                    mostrarError(error);

                });
        }

        console.log('saliendo de la funcion accionBotonOk');
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
