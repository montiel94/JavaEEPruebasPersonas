/**
 * Created by Daniel jose on 11/03/2017.
 */
angular.module('webAppVtrackApp')
    .directive('dashboarddirective',['$compile','$rootScope',dashboarddirective]);

function dashboarddirective($compile,$rootScope) {
    return {
        restrict: 'E',
        replace: true,
        link: function(scope, elem,rootScope) {
            var page = 'dashboard';
            if ($rootScope.page == 'dashboard')
                var html = '<p>estoy en el template de generar pedidos</p>';
            else
                var  html = '<p>estoy en el template de dashboard general<p></p>';
            elem.replaceWith($compile(html)(scope));
        },
        scope: true
    }
}

