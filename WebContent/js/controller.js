'use strict';

// FIXME alterar para produção

var app = angular.module('ffge', [ 'ui.bootstrap', 'ui.bootstrap.tpls', 'angularModalService' ]);

app.controller('FFCtrl', [ '$scope', '$http', 'ModalService', function($scope, $http, ModalService) {

    $scope.currentPage = 1;
    $scope.ff = {};
    $scope.ff.grosserias = [];

    $scope.load = function() {
        $http.get('http://pcbnu007999:8888/ffge/Servlet').then(function(success) {
            $scope.ff = success.data.ff;
            $scope.ff.grosserias = success.data.ff.grosserias.reverse();
        }, function(error) {
            console.log(error);
        });
    }

    $scope.openModal = function() {
        ModalService.showModal({
            templateUrl : 'modal.html',
            controller : "ModalController"
        }).then(function(modal) {
            modal.element.modal();

            modal.close.then(function(params) {
                console.log(params);
                if (!!params) {
                    $http.put('http://pcbnu007999:8888/ffge/Servlet', params).then(function(sucess) {
                        $scope.load();
                    }, function(error) {
                        console.log(error);
                    });

                }
            });
        });
    }

    $scope.openSubscribe = function() {
        ModalService.showModal({
            templateUrl : 'email.html',
            controller : "EmailController"
        }).then(function(modal) {
            modal.element.modal();

            modal.close.then(function(params) {
                console.log(params);
                if (!!params) {
                    $http.post('http://pcbnu007999:8888/ffge/Subscribe', params).then(function(sucess) {
                        if (params.acao == 'subscribe') {
                            console.log('email cadastrado com sucesso!');
                        } else if (params.acao == 'unsubscribe') {
                            console.log('email descadastrado com sucesso!');
                        }
                    }, function(error) {
                        console.log(error);
                    });

                }
            });
        });
    }

    $scope.templateDescricao = 'templateDescricao.html';
    $scope.templateReplica = 'templateReplica.html';

    $scope.getPage = function(currentPage) {
        return $scope.ff.grosserias.slice(parseInt(currentPage + '0') - 10, parseInt(currentPage + '0'));
    }
} ]);

app.controller('ModalController', function($scope, close) {

    $scope.modal = {};
    $scope.modal.acao = 'Grosseiro';

    $scope.sendOffense = function() {
        close($scope.modal, 500);
    }

    $scope.close = function(result) {
        close(undefined, 500); // close, but give 500ms for bootstrap to animate
    }

});

app.controller('EmailController', function($scope, close) {

    $scope.subscribeEmail = function() {
        $scope.modal.acao = 'subscribe';
        close($scope.modal, 500);
    }

    $scope.unsubscribeEmail = function() {
        $scope.modal.acao = 'unsubscribe';
        close($scope.modal, 500);
    }

    $scope.close = function(result) {
        close(undefined, 500); // close, but give 500ms for bootstrap to animate
    }

});
