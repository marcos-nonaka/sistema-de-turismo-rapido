import React, { useEffect, useState } from "react";
import { Meheader, Menav, Menavgist, Footer } from '../../../components'
import { getUserLocalStorage } from '../../../store/util'
import error from "../../../assets/img/error.png";

function Booking() {
	const userData = getUserLocalStorage()
	
	useEffect(() => {
	   document.body.classList.add('bg-internas-dashboard');
	}, []);
	
    return(
		<>
		<Meheader />
		<div id="main">
			<div className="container mt-5">				
				<div className="row">
					<div className="col-md-3 col-sm-12">
						{ userData.role == 'ROLE_TURISTA' ? <Menav /> : <Menavgist /> }
					</div>
					<div className="col-md-9 col-sm-12">
						<h2 className="h2 fw-bold mb-2">Minhas reservas</h2>
						<p className="mb-4">Administre sua experiência na Quatour</p>
						
						<div className="dashboard-content rounded-4 bg-white p-5 mb-5">
							{/*<h3 className="h3 fw-bold mb-4">Minhas reservas</h3>*/}
							<p className="text-center mt-5"><img src={error} width="200" /></p>
							<h4 className="h4 fw-bold text-center mt-5">Nenhuma reserva encontrada</h4>
							<p className="mb-5 text-center fw-bold">Que tal planejar seu próximo roteiro?</p>
							<p className="text-center mb-5"><a href="/pesquisar-roteiro" className="btn btn-warning rounded-5">Pesquisar roteiro</a></p>
						</div>
					</div>
				</div>

			</div>
		</div>
		<Footer />
		</>
	)
}


export default Booking;