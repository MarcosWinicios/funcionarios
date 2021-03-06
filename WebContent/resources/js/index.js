var inicio = new Vue({
    el: "#inicio",
    data: {
        lista: []
    },
    created: function() {
        let vm = this;
        vm.listarFuncionarios();
    },
    methods: {
        //Busca os itens para a lista da primeira página
        listarFuncionarios: function() {
            const vm = this;
            axios.get("/funcionarios/")
                .then(response => {
                    vm.lista = response.data;
                    console.log(vm)
                }).catch(function(error) {
                    vm.mostraAlertaErro("Erro interno", "Não foi listar natureza de serviços", error);
                }).finally(function() {});
        },
    }
});