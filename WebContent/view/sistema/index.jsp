<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>

    <meta charset="UTF-16LE">

    <title>SB Admin 2 - Dashboard</title>

    <c:import url="../util/importsCss.jsp"></c:import>
    <c:if test="${msg != null}">

        <script>
            alert("${msg}")
        </script>

    </c:if>
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <c:import url="../util/navBarLateral.jsp"></c:import>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <c:import url="../util/topBar.jsp"></c:import>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                            class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                </div>

                <!-- Content Row -->
                <div class="row">

                    <!-- Earnings (Monthly) Card Example -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-primary shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                            Renda Total(Liquida)
                                        </div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">R$<%=request.getSession().getAttribute("totalLiquido")%>
                                        </div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Earnings (Monthly) Card Example -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-success shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                            Renda Total(Bruta)
                                        </div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">R$<%=request.getSession().getAttribute("totalBruto")%>
                                        </div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Earnings (Monthly) Card Example -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-info shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Sobra Mensal
                                        </div>
                                        <div class="row no-gutters align-items-center">
                                            <div class="col-auto">
                                                <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">R$${sobraMensal}</div>
                                            </div>
                                            <div class="col">
                                                <div class="progress progress-sm mr-2">
                                                    <div class="progress-bar bg-info" role="progressbar"
                                                         style="width: ${porcentagemSobra}%" aria-valuenow="${porcentagemSobra}" aria-valuemin="0"
                                                         aria-valuemax="100"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Pending Requests Card Example -->
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-warning shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                            Pending Requests
                                        </div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">18</div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-comments fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Content Row -->


                <!-- Content Row -->
                <div class="row">

                    <!-- Content Column -->
                    <div class="col-lg-6 mb-4">

                        <!-- Project Card Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Cadastro de Dividas</h6>
                            </div>
                            <form class="user" method="post" action="cadastraDivida">
                                <div class="form-group">
                                    <input type="text" name="valor" class="form-control form-control-user"
                                           id="exampleInputEmail" aria-describedby="emailHelp"
                                           placeholder="Valor" value="">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="descricao" class="form-control form-control-user"
                                           id="exampleInputPassword" placeholder="Descricao">
                                </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                    Cadastrar
                                </button>
                                <hr>
                            </form>
                        </div>

                        <!-- Color System -->
                        <!--
                        <div class="row">
                            <div class="col-lg-6 mb-4">
                                <div class="card bg-primary text-white shadow">
                                    <div class="card-body">
                                        Primary
                                        <div class="text-white-50 small">#4e73df</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 mb-4">
                                <div class="card bg-success text-white shadow">
                                    <div class="card-body">
                                        Success
                                        <div class="text-white-50 small">#1cc88a</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 mb-4">
                                <div class="card bg-info text-white shadow">
                                    <div class="card-body">
                                        Info
                                        <div class="text-white-50 small">#36b9cc</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 mb-4">
                                <div class="card bg-warning text-white shadow">
                                    <div class="card-body">
                                        Warning
                                        <div class="text-white-50 small">#f6c23e</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 mb-4">
                                <div class="card bg-danger text-white shadow">
                                    <div class="card-body">
                                        Danger
                                        <div class="text-white-50 small">#e74a3b</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 mb-4">
                                <div class="card bg-secondary text-white shadow">
                                    <div class="card-body">
                                        Secondary
                                        <div class="text-white-50 small">#858796</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 mb-4">
                                <div class="card bg-light text-black shadow">
                                    <div class="card-body">
                                        Light
                                        <div class="text-black-50 small">#f8f9fc</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 mb-4">
                                <div class="card bg-dark text-white shadow">
                                    <div class="card-body">
                                        Dark
                                        <div class="text-white-50 small">#5a5c69</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    -->
                    </div>


                        <div class="col-lg-6 mb-4">

                            <!-- Illustrations -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Dividas do mes</h6>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-bordered">
                                            <tr>
                                                <th>Description</th>
                                                <th>Valor</th>
                                            </tr>

                                            <c:forEach items="${dividasDoMes}" var="divida">

                                                <tr>
                                                    <td>${divida.descricao}</td>
                                                    <td>
                                                        <center>
                                                            R$${divida.valor}
                                                        </center>
                                                    </td>
                                                </tr>

                                            </c:forEach>
                                            <tr>
                                                <td>Total:</td>
                                                <td>
                                                    <center>
                                                        R$${totalDividas}</center>
                                                </td>
                                            </tr>

                                        </table>
                                    </div>
                                </div>
                            </div>

                        <!-- Approach -->
                        <!--
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Development Approach</h6>
                            </div>
                            <div class="card-body">
                                <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce
                                    CSS bloat and poor page performance. Custom CSS classes are used to create
                                    custom components and custom utility classes.</p>
                                <p class="mb-0">Before working with this theme, you should become familiar with the
                                    Bootstrap framework, especially the utility classes.</p>
                            </div>
                        </div>
                        -->
                    </div>
                </div>

                <div class="row">

                    <!-- Content Column -->
                    <div class="col-lg-6 mb-4">

                        <!-- Project Card Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Cadastro de Renda</h6>
                            </div>
                            <form class="user" method="post" action="cadastraRenda">
                                <div class="form-group">
                                    <input type="text" name="valor" class="form-control form-control-user"
                                           id="exampleInputEmail" aria-describedby="emailHelp"
                                           placeholder="Valor" value="">
                                </div>
                                <div class="form-group">
                                    <select class="form-control" required="required" name="isSalario">
                                        <option value="">-------------Salario?-----------</option>
                                        <option value="1">
                                            Yes
                                        </option>
                                        <option value="0">
                                            No
                                        </option>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                    Cadastrar
                                </button>
                                <hr>
                            </form>
                        </div>

                    </div>

                    <div class="col-lg-6 mb-4">

                        <!-- Illustrations -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Todas as rendas</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th>Valor bruto</th>
                                            <th>Valor liquido</th>
                                        </tr>

                                        <c:forEach items="${rendas}" var="renda">

                                            <tr>
                                                <td>
                                                    <center>
                                                        R$${renda.valorBruto}
                                                    </center>
                                                </td>
                                                <td>
                                                    <center>
                                                        R$${renda.valorLiquido}
                                                    </center>
                                                </td>
                                            </tr>

                                        </c:forEach>
                                        <tr>
                                            <td>Total:</td>
                                            <td>
                                                <center>
                                                    R$${rendaTotal}
                                                </center>
                                            </td>
                                        </tr>

                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>

                <!-- Desejos -->

                <div class="row">

                    <!-- Content Column -->
                    <div class="col-lg-6 mb-4">

                        <!-- Project Card Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Cadastro de desejo</h6>
                            </div>
                            <form class="user" method="post" action="cadastraDesejo">
                                <div class="form-group">
                                    <input type="text" name="descricao" class="form-control form-control-user"
                                           id="exampleInputEmail" aria-describedby="emailHelp"
                                           placeholder="Descricao" value="">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="valor" class="form-control form-control-user"
                                           id="exampleInputEmail" aria-describedby="emailHelp"
                                           placeholder="Valor" value="">
                                </div>
                                <div class="form-group">
                                    <input type="date" name="dataDeCompra" class="form-control form-control-user"
                                           id="exampleInputEmail" aria-describedby="emailHelp"
                                           placeholder="Valor" value="">
                                </div>

                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                    Cadastrar
                                </button>
                                <hr>
                            </form>
                        </div>

                    </div>

                    <div class="col-lg-6 mb-4">

                        <!-- Illustrations -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Desejos de compra</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th>Description</th>
                                            <th>Valor</th>
                                            <th>Quando Deseja Comprar?</th>
                                            <th>Jah foi comprado?</th>
                                            <th>Actions</th>
                                        </tr>

                                        <c:forEach items="${desejos}" var="desejo">

                                            <tr>
                                                <td>${desejo.descricao}</td>
                                                <td>
                                                    <center>
                                                        R$${desejo.valor}
                                                    </center>
                                                </td>
                                                <td>${desejo.dataDeCompra}</td>
                                                <th>
                                                    <c:choose>
                                                        <c:when test="${desejo.status}">
                                                            Sim
                                                        </c:when>
                                                        <c:otherwise>
                                                            Nops ;-;
                                                        </c:otherwise>
                                                    </c:choose>
                                                </th>
                                                <th></th>
                                            </tr>

                                        </c:forEach>
                                        <tr>
                                            <td>Total:</td>
                                            <td colspan="4">
                                                <center>
                                                    R$${valorTotalDesejos}
                                                </center>
                                            </td>
                                        </tr>

                                    </table>
                                </div>
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