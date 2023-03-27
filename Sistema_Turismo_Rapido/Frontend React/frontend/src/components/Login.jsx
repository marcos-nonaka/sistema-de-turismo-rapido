import React from "react";

import "../assets/css/login.css";

import LogoQuatour from "../assets/img/logo-icon.svg";

function Login() {
  return (
    <>
      <div className="text-center">
        <div className="login-form m-auto">
          <form className="row rounded-3">
            <p className="text-center mb-5">
              <a href="/">
                <img src={LogoQuatour} alt="Logo Quatour" />
              </a>
            </p>

            <div className="col-md-12 mb-2">
              <input
                type="text"
                name="username"
                className="form-control"
                id="username"
                placeholder="Seu usuário"
              />
            </div>

            <div className="col-md-12 mb-4">
              <div className="input-group">
                <input
                  type="password"
                  name="password"
                  className="form-control"
                  id="password"
                  aria-describedby="password"
                  placeholder="Sua senha"
                />
                <span className="input-group-text" onclick="changeIcon()">
                  <i className="bi bi-eye-slash"></i>
                </span>
              </div>
            </div>

            <div className="col-md-12">
              <a href="#" className="float-start text-muted mb-2 forgot">
                Esqueceu sua senha?
              </a>

              <button
                className="btn btn-primary rounded-5 float-end"
                type="button"
              >
                Acessar
              </button>
            </div>
          </form>

          <p className="mt-4 text-muted signup-link">
            Não possui uma conta?{" "}
            <a href="cadastre-se.html">
              <strong>Cadastre-se.</strong>
            </a>
          </p>
        </div>
      </div>
    </>
  );
}

export default Login;
