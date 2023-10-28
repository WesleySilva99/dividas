<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>

    <meta charset="UTF-16LE">

    <title>SB Admin 2 - Dashboard</title>

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
                            <form class="user" method="post" action="cadastraCamarote">
                                <div class="form-group">
                                    <input type="text" name="descricao" class="form-control form-control-user"
                                           id="exampleInputEmail" aria-describedby="emailHelp"
                                           placeholder="Descricao" value="">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="localizacao" class="form-control form-control-user"
                                           id="exampleInputEmail" aria-describedby="emailHelp"
                                           placeholder="Localizacao" value="">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="valor" class="form-control form-control-user"
                                           id="exampleInputEmail" aria-describedby="emailHelp"
                                           placeholder="Valor" value="">
                                </div>
                                <div class="form-group" >
                                    <select name="idLote" id="lote" class="form-control">
                                        <option value="">--------------------------SELECIONE--------------------------</option>
                                        <c:forEach items="${lotes}" var="lote">
                                            <option value="${lote.id}">${lote.descricao}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                    Cadastrar
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