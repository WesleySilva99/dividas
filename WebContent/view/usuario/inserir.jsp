<!DOCTYPE html>
<html lang="br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Cadastrar Usuario</title>

    <script>
        function validarCadastro() {
            var senha = document.formulario.senha.value;
            var senhaRepetida = document.formulario.passwd2.value;
            if (senha != senhaRepetida) {
                alert("As senhas não conferem. Repita a senha corretamente!");
                document.formulario.passwd2.focus();
                return false;
            }
            if (senha.length < 8 || senha.length > 32) {
                alert("As senhas estão abaixo ou acima do limite de caracteres! Senhas de 8 até 32 caracteres!");
                document.formulario.passwd2.focus();
                return false;
            }
            if (document.formulario.email.value == "" || document.formulario.email.value.indexOf('@') == -1 || document.formulario.email.value.indexOf('.') == -1) {
                alert("Preencha corretamente o campo email!");
                document.formulario.email.focus();
                return false;
            }
        }

        contDiv = 1;

        function removeRenda(id) {
            id.parentNode.removeChild(id);
        }

        function criaRenda(add) {
            if (add) {
                contDiv++;
            }
            var table = document.getElementById("rendas");
            var clone = table.cloneNode(true);
            clone.id = ("rendas" + contDiv);
            var button = document.createElement("button");
            button.setAttribute("onClick", "removeRenda(" + clone.id + ")");
            button.setAttribute("class", "btn btn-sm btn-danger");
            button.innerHTML = "Remover Renda";
            clone.appendChild(button);
            document.getElementById("setRendas").appendChild(clone);
        }


    </script>

    <c:import url="../util/importsCss.jsp"></c:import>
    <c:if test="${msg != null}">

        <script>
            alert("${msg}")
        </script>

    </c:if>
</head>

<body class="bg-gradient-primary">

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Crie Uma Conta!</h1>
                        </div>
                        <form class="user" method="post" name="formulario" onsubmit="return validarCadastro()"
                              action="inserirUsuario">
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="text" name="nome" class="form-control form-control-user"
                                           id="exampleFirstName"
                                           placeholder="Nome" value="${user.nome}">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="login" class="form-control form-control-user"
                                           id="exampleLastName"
                                           placeholder="Login" value="${user.login}">
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control form-control-user" name="email"
                                       id="exampleInputEmail"
                                       placeholder="Email Address" value="${user.email}">
                            </div>
                            <table id="rendas">
                                <tr>
                                    <td>
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="text" name="valor" class="form-control form-control-user"
                                                       id="exampleFirstName"
                                                       placeholder="Renda" value="" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');">
                                            </div>
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                Salario?
                                                <button type="button" onclick="criaRenda(true)"
                                                        class="btn-sm btn-success"> ADD Renda
                                                </button>
                                                <br>
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
                                        </div>
                                    </td>
                                </tr>
                            </table>
                            <div id="setRendas">

                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="password" name="senha" class="form-control form-control-user"
                                           id="exampleInputPassword" placeholder="Senha">
                                </div>
                                <div class="col-sm-6">
                                    <input type="password" name="passwd2" class="form-control form-control-user"
                                           id="exampleRepeatPassword" placeholder="Repeat Password">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary btn-user btn-block">
                                Registrar-se
                            </button>
                            <hr>
                            <!--
                            <a href="index.html" class="btn btn-google btn-user btn-block">
                                <i class="fab fa-google fa-fw"></i> Register with Google
                            </a>
                            <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                            </a>
                            -->
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="forgot-password.html">Forgot Password?</a>
                        </div>
                        <div class="text-center">
                            <a class="small" href="/dividas/">Already have an account? Login!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>

</html>