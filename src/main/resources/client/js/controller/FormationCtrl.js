myApp.controller("FormationCtrl", function ($scope, $rootScope, $http) {
    console.log("Hello world");
    $http.get("http://localhost:8090/formations")
        .then((response) => {
            $scope.formations = response.data;
            $(document).ready(function () {
                $('#example').DataTable();
            });
        });
    $rootScope.$on("updateFormations", () => {
        $http.get("http://localhost:8090/formations")
            .then((response) => {
                $scope.formations = response.data;
            })
    });
    $scope.delete = (id) => {
        swal({
            title: "êtes-vous sûre ?",
            text: "c'est irréversible !! ",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
            .then((resultat) => {
                if (resultat) {
                    $http.delete("http://localhost:8090/formations/" + id + "/")
                    .then((res) => {
                        $rootScope.$broadcast("updateFormations");
                        swal("Formation bien supprimée", {
                            icon: "success",
                        });
                    }, (err) => {
                        swal("dsd","sdds", "error");
                    })
                } else {
                    //swal("KO");
                }
            });
    };  
});

myApp.controller("detailFormationCtrl", function ($scope, $http, $stateParams) {
    console.log($stateParams);
    $scope.formation = {};
    $http.get("http://localhost:8090/formations/" + $stateParams.id + "/")
        .then((response) => {
            $scope.formation = response.data;
        })
});
myApp.controller("ajoutFormationCtrl", function ($scope, $http, $state, $rootScope) {
    $scope.formation = {};
    $scope.ajouter = () => {
        console.log("sfsdfsd");
        $http.post("http://localhost:8090/formations/", $scope.formation)
            .then(function (formation) {
                $rootScope.$broadcast("updateFormations");
                $state.go("formations");
                swal("Formation bien ajoutée", "Good job!", "success");
            }, (err) => {
                swal("Erreur lors de l'ajout", "! ! !", "error");
            });
    }
});
myApp.controller("modifierFormationCtrl", function ($scope, $http, $state, $rootScope, $stateParams) {
    $scope.formation = {};
    $http.get("http://localhost:8090/formations/" + $stateParams.id + "/")
        .then((response) => {
            $scope.formation = response.data;
            console.log("hani");
        });
    $scope.modifier = () => {
        console.log("modifier");
        $http.post("http://localhost:8090/formations/", $scope.formation)
            .then(function (formation) {
                $rootScope.$broadcast("updateFormations");
                $state.go("formations");
                swal("Formation bien modifiée", "Good job!", "success");
            }, (err) => {
                swal("Erreur lors de la modification", "! ! !", "error");
            });

    }
});
