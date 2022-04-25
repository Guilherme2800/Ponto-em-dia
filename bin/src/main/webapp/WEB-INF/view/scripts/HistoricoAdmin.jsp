<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>

function editar(e) {

    var linha = $(e).closest("tr");
    var user_id = linha.find("td:eq(0)").text().trim();
    var data = linha.find("td:eq(1)").text().trim();
    var entrada = linha.find("td:eq(2)").text().trim();
    var almoco = linha.find("td:eq(3)").text().trim();
    var voltaAlmoco = linha.find("td:eq(4)").text().trim();
    var saida = linha.find("td:eq(5)").text().trim();

    $("#user_id_update").val(user_id);
    $("#user_id_remove").val(user_id);
    $("#data_update").val(data);
    $("#data_remove").val(data);
    $("#horaEntrada").val(entrada);
    $("#horaAlmoco").val(almoco);
    $("#horaVoltaAlmoco").val(voltaAlmoco);
    $("#horaSaida").val(saida);

}

$(document).ready(function () {
        $('#tabelaHistorico').DataTable(
                {
                    "language": {
                        "lengthMenu": "Registros por página:  _MENU_",
                        "zeroRecords": "Nada encontrado",
                        "info": "Mostrando página _PAGE_ de _PAGES_",
                        "infoEmpty": "Nenhum registro disponível",
                        "infoFiltered": "(filtrado de _MAX_ registros no total)"
                    }
                });
    });

</script>
</body>
</html>