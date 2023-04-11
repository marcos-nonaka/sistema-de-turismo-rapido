import React from "react";
import { NavLink, useMatch, useResolvedPath } from 'react-router-dom';
import avatar from "../../../assets/img/profile_pic.png";
import { getUserLocalStorage } from '../../../store/util'

function Menav(){
	const userData = getUserLocalStorage()
	
	return(
		<div className="rounded-4 p-4 pt-0 menav">
			<div className=" text-center mb-5">
				<img className="avatar-img rounded-circle" src={avatar} alt="avatar" />
				<p className="m-0"><strong>{userData.name}...</strong></p>
				<p className="small m-0">{userData.mail}</p>
			</div>
			<ul className="nav flex-column">
				<li className="nav-item">
					<NavLink className={({ isActive }) => isActive ? 'nav-link active' : 'nav-link' } to="/me/profile"><i className="bi bi-person-fill-gear me-1"></i> Minha conta</NavLink>
				</li>
				<li className="nav-item">
					<NavLink className={({ isActive }) => isActive ? 'nav-link active' : 'nav-link' } to="/me/booking"><i className="bi bi-ticket-detailed-fill me-1"></i> Minhas reservas</NavLink>
				</li>
				<li className="nav-item">
					<NavLink className={({ isActive }) => isActive ? 'nav-link active disabled' : 'nav-link disabled' } to="/me/payment"><i className="bi bi-credit-card-2-back-fill  me-1"></i> Formas de pagamento</NavLink>
				</li>					
				<li className="nav-item">
					<NavLink className={({ isActive }) => isActive ? 'nav-link active disabled' : 'nav-link disabled' } to="/me/delete"><i className="bi bi-file-x-fill me-1"></i> Excluir cadastro</NavLink>
				</li>
				<li className="nav-item">
					<NavLink className={({ isActive }) => isActive ? 'nav-link active disabled' : 'nav-link disabled' } to="/me/favorite"><i className="bi bi-bookmark-heart-fill"></i> Favoritos</NavLink>
				</li>				
				<li className="nav-item">
					<NavLink className={({ isActive }) => isActive ? 'nav-link active fw-bold' : 'nav-link fw-bold' } to="/logout"><i className="bi bi-box-arrow-in-right me-1"></i> Logout</NavLink>
				</li>
			</ul>
		</div>
	)
}

export default Menav;