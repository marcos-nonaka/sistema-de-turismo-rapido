import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import { getUserLocalStorage } from '../../../store/util'

import LogoTop from "../../../assets/img/logo-top.svg";


function Navuser(){
	const [isNavbarNormal, setIsNavbarNormal] = useState(false);
	//const [isLogged, setIsLogged] = useState(false);
	//const [currentUser, setCurrentUser] = useState(false);
	
	const url = useLocation();
	let internas = '';

	if(url.pathname != '/'){
		internas = 'internas';
	}

	useEffect(() => {
		window.addEventListener(
			"scroll", () => {
				const scroll = window.pageYOffset;

				if(scroll > 1){
					setIsNavbarNormal(true);
				}else{
					setIsNavbarNormal(false);
				}
			},
		);
	}, []);
  
	/*const session = getUserLocalStorage()
	if(!session){
		setIsLogged(false)
	}else{
		setIsLogged(true)
	}*/
  
  
    return(
    <div id="header" className={`${isNavbarNormal ? "min" : ""} ${internas}`}>
      <nav className="navbar navbar-expand-md navbar-dark">
        <div className="container">
          <a
            className="navbar-brand d-flex align-items-center col-md-3 mb-md-0 text-dark text-decoration-none"
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
                <a className="nav-link" href="/cadastre-se">
                  Seja um turismólogo
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/fale-conosco">
                  Fale conosco
                </a>
              </li>
            </ul>

            <div className="d-flex">
				<ul className="navbar-nav ms-md-auto d-none">			
					<li className="nav-item dropdown ms-5">
						<a href="#" id="dropdown-menu" role="button" data-bs-auto-close="outside" data-bs-display="static" data-bs-toggle="dropdown" aria-expanded="false">
							<div className="avatar avatar-p p-0 me-2"><img className="avatar-img rounded-circle" src={''} alt="avatar" /></div>
							Nome Usuário...
							<i className="ms-1 bi bi-chevron-down"></i>
						</a>
						
						<ul className="dropdown-menu dropdown-menu-end shadow pt-3" aria-labelledby="profileDropdown">
							<li className="px-3 mb-3">
								<div className="d-flex align-items-center">
									<div className="avatar me-3">
										<img className="avatar-img rounded-circle shadow" src={''} alt="avatar" />
									</div>
									<div>
										<p className="m-0"><strong>Nome Usuário...</strong></p>
										<p className="small m-0">email@email.com.br</p>
									</div>
								</div>
							</li>
	
							<li> <hr className="dropdown-divider" /></li>
							<li><a className="dropdown-item" href="/me/profile"><i className="bi bi-person fa-fw me-2"></i>Minha conta</a></li>
							<li><a className="dropdown-item" href="/me/booking"><i className="bi bi-bookmark-check fa-fw me-2"></i>Minhas reservas</a></li>

							<li><a className="dropdown-item bg-danger-soft-hover" href="/logout"><i className="bi bi-power fa-fw me-2"></i>Logout</a></li>
							<li><hr className="dropdown-divider" /></li>

						</ul>
					</li>
				</ul>
			
			</div>
          </div>
        </div>
      </nav>
    </div>
	)

}

export default Navuser;