import React from "react";

import LogoTop from "../assets/img/logo-top.svg";

function Navbar() {
  var elem = document.getElementById('header');
      
  window.addEventListener('scroll', function() {
    let scroll = window.pageYOffset;

    if(scroll > 1){
      elem.classList.add("min");
    }else{
      elem.classList.remove("min");
    }
  });

  return (
    <div id="header" className="internas">
      <nav className="navbar navbar-expand-md navbar-dark">
        <div className="container">
          <a
            className="navbar-brand d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none"
            href="/"
          >
            <img src={LogoTop} id="logo" alt="Logo Quatour" />
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarCollapse"
            aria-controls="navbarCollapse"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarCollapse">
            <ul className="navbar-nav me-auto mb-2 mb-md-0 justify-content-center">
              <li className="nav-item">
                <a className="nav-link" href="/">
                  Home
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/quem-somos">
                  Sobre a Quatour
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/pesquisar-roteiro">
                  Roteiros
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="fale-conosco.html">
                  Fale conosco
                </a>
              </li>
            </ul>

            <div className="d-flex">
              <ul className="navbar-nav ms-md-auto">
                <li className="nav-item">
                  <a
                    className="btn btn-outline-light rounded-pill ms-4  me-3 ps-4 pe-4"
                    href="login.html"
                  >
                    Login
                  </a>
                </li>
                <li className="nav-item">
                  <a
                    className="btn btn-outline-warning rounded-pill ps-4 pe-4"
                    href="cadastre-se.html"
                  >
                    Cadastre-se
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </nav>
    </div>
  );
}

export default Navbar;
