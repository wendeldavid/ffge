'use strict';

var app = angular.module('ffge', [ 'ui.bootstrap', 'ui.bootstrap.tpls' ]);

app.controller('FFCtrl', [
		'$rootScope',
		'$scope',
		function($rootScope, $scope) {

			$scope.currentPage = 1;
			$scope.offset = 0;
			$scope.limit = 9;
			$scope.ff = {};
			$scope.ff.grosserias = [];

			$scope.paginate = function() {
				$scope.offset = parseInt($scope.currentPage + '0') - 10,
						parseInt($scope.currentPage + '0');
				$scope.limit = $scope.currentPage + 10;
			}

			$scope.load = function() {

				var config = {
					apiKey : "AIzaSyAXS9kKJzKYmmbapS3Z7BKHjwri1_lInhA",
					authDomain : "ffge-9a4e7.firebaseapp.com",
					databaseURL : "https://ffge-9a4e7.firebaseio.com",
					storageBucket : "ffge-9a4e7.appspot.com",
					messagingSenderId : "106420336131"
				};
				firebase.initializeApp(config);

				var database = firebase.database();

				var recorde = firebase.database().ref('recorde');
				recorde.on('value', function(snapshot) {
					$scope.$apply(function() {
						$scope.ff.recorde = snapshot.val();
					});
				});

				var dias = firebase.database().ref('dias');
				dias.on('value', function(snapshot) {
					$scope.$apply(function() {
						$scope.ff.dias = snapshot.val();
					});
				});

				var grosserias = firebase.database().ref('grosserias');
				grosserias.on('value', function(snapshot) {
					$scope.$apply(function() {
						$scope.ff.grosserias = snapshot.val().reverse();
					});
				});
			}

			$scope.getPage = function(currentPage) {
				return $scope.ff.grosserias.slice(
						parseInt(currentPage + '0') - 10,
						parseInt(currentPage + '0')).reverse();
			}

		} ]);
