myApp.controller("EnseignantCtrl", function ($scope, $rootScope, $http) {
    console.log("Hello world");
    $http.get("http://localhost:8090/enseignants")
        .then((response) => {
            $scope.enseignants = response.data;
            setTimeout(() => {
                $(document).ready(function () {
                    $('#example').DataTable();
                });
            }, 0)
        });
    $rootScope.$on("updateEnseignant", () => {
        $http.get("http://localhost:8090/enseignants")
            .then((response) => {
                $scope.enseignants = response.data;
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
                    $http.delete("http://localhost:8090/enseignants/id/" + id + "/")
                        .then((res) => {
                            $rootScope.$broadcast("updateEnseignant");
                            swal("Enseignant bien supprimé", {
                                icon: "success",
                            });
                        }, (err) => {
                            swal("dsd", "sdds", "error");
                        })
                } else {
                    //swal("KO");
                }
            });
    };
});

myApp.controller("detailEnseignantCtrl", function ($scope, $http, $stateParams) {
    console.log($stateParams);
    $scope.enseignant = {};
    $http.get("http://localhost:8090/enseignants/id/" + $stateParams.id + "/")
        .then((response) => {
            $scope.enseignant = response.data;
        })
});

myApp.controller("ajoutEnseignantCtrl", function ($scope, $http, $state, $rootScope) {
    $scope.enseignant = {};
    $scope.ajouter = () => {
        console.log("sfsdfsd");
        $http.post("http://localhost:8090/enseignants/", $scope.enseignant)
            .then(function (enseignant) {
                $rootScope.$broadcast("updateEnseignant");
                $state.go("enseignants");
                swal("Enseignant bien ajouté", "Good job!", "success");
            }, (err) => {
                swal("Erreur lors de l'ajout", "! ! !", "error");
            });
    }
});

myApp.controller("modifierEnseignantCtrl", function ($scope, $http, $state, $rootScope, $stateParams) {
    $scope.enseignant = {};
    $http.get("http://localhost:8090/enseignants/id/" + $stateParams.id + "/")
        .then((response) => {
            $scope.enseignant = response.data;
            console.log("hani");
        });
    $scope.modifier = () => {
        console.log("modifier");
        $http.post("http://localhost:8090/enseignants/", $scope.enseignant)
            .then(function (enseignant) {
                $rootScope.$broadcast("updateEnseignant");
                $state.go("enseignants");
                swal("Enseignant bien modifié", "Good job!", "success");
            }, (err) => {
                swal("Erreur lors de la modification", "! ! !", "error");
            });

    }
});