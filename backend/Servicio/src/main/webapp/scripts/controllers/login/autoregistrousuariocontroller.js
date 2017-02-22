/**
 * Created by Daniel jose on 22/02/2017.
 */
angular.module('webAppVtrackApp')
    .controller('autoregistrousuariocontroller', autoregistrousuariocontroller);


function autoregistrousuariocontroller ($scope, $element, title, close,$timeout,ServicioLogin) {

    var view = $scope;
    $scope.title = title;
    $scope.valorBoton = 1;


    //  This cancel function must use the bootstrap, 'modal' function because
    //  the doesn't have the 'data-dismiss' attribute.
    $scope.cancel = function() {

        //  Manually hide the modal.
        $element.modal('hide');

    };

    $scope.accionBotonOk = function (){
        console.log('entrando a la funcion accionBotonOk');
        if (validarCorreo())
        {
            ServicioLogin.validarAutoregistro(view.correo)
                .then(function(data){
                    console.log('se realizo login exitosamente');
                    //var error = data;
                    //$element.modal('hide');
                    //close({
                      //  exito : '1'
                    //}, 500);
                })
                .catch(function (error) {
                    console.log('se produjo un error en el login');
                    mostrarError(error);
                });
        }
        console.log('saliendo de la funcion accionBotonOk');
    }

    function validarCorreo() {
        console.log('entrando al metodo validar');
        if (!view.correo) {
            mostrarError('El campo correo electronico es obligatorio');
            return false;
        }
        if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(view.correo))
        {
            mostrarError('Correo electronico no cumple con formato');
            return false;
        }
        return true;
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
