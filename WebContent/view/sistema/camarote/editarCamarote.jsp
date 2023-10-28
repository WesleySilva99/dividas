<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>

    <meta charset="UTF-16LE">

    <title>Alterar Camarote</title>

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
                    <div class="card shadow mb-lg-auto" style="margin-left: 10%">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Cadastro de camarote</h6>
                        </div>
                        <form class="user" method="post" action="editarCamarote">
                            <input type="hidden" name="id" value="${camarote.id}">
                            <div class="form-group">
                                <input type="text" name="descricao" class="form-control form-control-user"
                                       id="exampleInputEmail" aria-describedby="emailHelp"
                                       placeholder="Descricao" value="${camarote.descricao}">
                            </div>
                            <div class="form-group">
                                <input type="text" name="localizacao" class="form-control form-control-user"
                                       id="exampleInputEmail" aria-describedby="emailHelp"
                                       placeholder="Localizacao" value="${camarote.localizacao}">
                            </div>
                            <div class="form-group">
                                <input type="text" name="valor" class="form-control form-control-user"
                                       id="exampleInputEmail" aria-describedby="emailHelp"
                                       placeholder="Valor" value="${camarote.valor}">
                            </div>
                            <div class="form-group" >
                                <select name="idLote" id="lote" class="form-control">
                                    <option value="">--------------------------SELECIONE--------------------------</option>
                                    <c:forEach items="${lotes}" var="lote">
                                        <c:choose>
                                            <c:when test="${camarote.lote.id == lote.id}">
                                                <option value="${lote.id}" selected="selected">${lote.descricao}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${lote.id}">${lote.descricao}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group" >
                                <select name="status" id="status" class="form-control">
                                    <option value="">--------------------------SELECIONE--------------------------</option>
                                    <c:forEach items="${listaStatus}" var="status">
                                        <c:choose>
                                            <c:when test="${camarote.status == status.codigo}">
                                                <option value="${status.codigo}" selected="selected">${status.descricao}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${status.codigo}">${status.descricao}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>

                            <button type="submit" class="btn btn-primary btn-user btn-block">
                                Alterar
                            </button>
                            <hr>
                        </form>
                    </div>
                    </center>
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