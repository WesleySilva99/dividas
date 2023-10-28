<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>

    <meta charset="UTF-16LE">

    <title>Lista de camarotes</title>

    <script !src="">

        function deletar(id, descricao){

            if(confirm("Tem certeza que deseja remover o camarote: " + descricao)){

            }else {
                return false;
            }

        }

    </script>

    <c:import url="../../util/importsCss.jsp"></c:import>
    <c:if test="${msg != null}">

        <script>
            alert("${msg}")
        </script>

    </c:if>
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <c:import url="../../util/navBarLateral.jsp"></c:import>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <c:import url="../../util/topBar.jsp"></c:import>

            <!-- Begin Page Content -->

            <div class="row">
                <!-- Content Column -->

                <div class="col-lg-auto mb-4">

                    <!-- Illustrations -->
                    <div class="card shadow mb-lg-auto" >
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Camarotes Cadastrados</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <tr>
                                        <th>Descricao</th>
                                        <th>Localizacao</th>
                                        <th>Valor</th>
                                        <th>Lote</th>
                                        <th>Status da compra</th>
                                        <th>Actions</th>
                                    </tr>

                                    <c:forEach items="${camarotes}" var="camarote">

                                        <tr>
                                            <td>${camarote.descricao}</td>
                                            <td>${camarote.localizacao}</td>
                                            <td>R$${camarote.valor}</td>
                                            <td>${camarote.lote.descricao}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${camarote.status == 1}">
                                                        Cadastrado, possivel compra
                                                    </c:when>
                                                    <c:when test="${camarote.status == 2}">
                                                        Comprado, só esperar pra curtir u.u
                                                    </c:when>
                                                    <c:when test="${camarote.status == 3}">
                                                        Desistencia, tinham outras opções.
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <a href="exibirEditarCamarote?id=${camarote.id}" class="btn btn-info btn-circle btn-lg">
                                                    <i class="fas fa-info-circle"></i>
                                                </a>
                                                <a class="btn btn-danger btn-circle btn-lg" href="removerCamarote?id=${camarote.id}"
                                                   onclick="return confirm('Tem certeza que deseja remover o camarote: ${camarote.descricao}')">
                                                    <i class="fas fa-trash"></i>
                                                </a>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                    <tr>
                                        <td>Total:</td>
                                        <td colspan="5">
                                            <center>
                                                ${valorTotalCamarotes}
                                            </center>
                                        </td>
                                    </tr>

                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

</body>

</html>