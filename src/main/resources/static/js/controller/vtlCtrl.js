app.controller('vtrCtrl',['vtrService','$scope', function(vtrService, $scope){
	 $scope.selectedSize;
	 
	 $scope.selectSize = function(size){
		 $scope.selectedSize = "Selected size: "+size;
	 }
}]);

//custom directive

app.directive('clothsizediv', function() {
    var directive = {};

    directive.restrict = 'E'; /* restrict this directive to elements */
    directive.templateUrl = '/views/clothsize.html';

    return directive;
});