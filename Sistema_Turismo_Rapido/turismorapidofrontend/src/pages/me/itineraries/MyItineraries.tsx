import React, {useEffect, useContext, useState} from 'react'
import axios, { AxiosError } from 'axios'
import { Meheader, Menav, Menavgist, Footer } from '../../../components'
import Alertify from "../../../components/alertify/Alertify";
import { useNavigate } from 'react-router-dom'
import { getUserLocalStorage } from '../../../store/util'
import error from "../../../assets/img/error.png";

function MyItineraries(){
	const userData = getUserLocalStorage()
	const token = getUserLocalStorage().token

	const navigate = useNavigate()
	
	useEffect(() => {
		document.body.classList.remove('bg-internas-login');
		document.body.classList.add('bg-internas-dashboard');
	}, []);


    return(
		<>
		<Meheader />
		<div id="main">
			<div className="container">				
				<div className="row">
					<div className="col-md-3 col-sm-12">
						{ userData.role == 'ROLE_TURISTA' ? <Menav /> : <Menavgist /> }
					</div>
					<div className="col-md-9 col-sm-12">
						<h2 className="h2 fw-bold mb-2">Meus roteiros</h2>
						<p className="mb-4">Administre sua experiência na Quatour</p>
				
						<div className="dashboard-content rounded-4 bg-white p-5 mb-5">
							<p className="text-center mt-5"><img src={error} width="200" /></p>
							<h4 className="h4 fw-bold text-center mt-5">Nenhum roteiro encontrada</h4>
							<p className="mb-5 text-center fw-bold">Que cadastrar um roteiro?</p>
							<p className="text-center mb-5"><a href="/me/cadastrar-roteiro" className="btn btn-warning rounded-5">Cadastrar roteiro</a></p>
						</div>
					</div>
				</div>

			</div>
		</div>
		
		<Footer />
		</>
	)

}

export default MyItineraries;