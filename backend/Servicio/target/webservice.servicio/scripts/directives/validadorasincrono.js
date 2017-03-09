/**
 * Created by Daniel jose on 24/02/2017.
 */
angular.module('webAppVtrackApp')
    .directive('validadorasincrono',validadorasincrono);

function validadorasincrono($http, $q,BASE_URL,$timeout) {
    return {
        restrict: 'A',
        scope: {
        },
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
            ngModel.$asyncValidators.asincValidator = function (correo) {
                var usuario = {"username": correo,"password": null};
                var defered = $q.defer();
                var promise = defered.promise;
                $http
                ({
                    method: 'post',
                    url: BASE_URL + '/usuario/autoRegistro',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    data: JSON.stringify(usuario)
                }).then(function success(response)
                {
                    console.log(response);
                    defered.resolve();
                },function error(response)
                {
                    console.log('error: '+response);
                    var error = response.data;
                    defered.reject();
                });
                return promise;
            };
        }
    };


}
