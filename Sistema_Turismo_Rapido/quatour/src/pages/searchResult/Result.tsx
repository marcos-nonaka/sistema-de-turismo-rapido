import React, { useEffect, useState } from 'react'
import { useNavigate, useLocation } from 'react-router-dom';
import axios, { AxiosError } from 'axios'
import { Navbar, Navuser, Footer } from '../../components'
import { getUserLocalStorage } from '../../store/util'
import { MapContainer, TileLayer, useMap, Marker, Popup } from 'react-leaflet'
import "leaflet/dist/leaflet.css";
import markerIconPng from "leaflet/dist/images/marker-icon.png"
import {Icon} from 'leaflet'
import Alertify from "../../components/alertify/Alertify";

//import OuroPreto1 from '../../assets/img/destinations/ouro-preto2.jpg'
//import OuroPreto2 from '../../assets/img/destinations/img2.jpg'
//import OuroPreto3 from '../../assets/img/destinations/img3.jpg'

//import SaoPaulo from '../../assets/img/destinations/sao-paulo.png'

import profilePic from '../../assets/img/profile_pic.png'

import Florianopolis from '../../assets/img/destinations/florianopolis2.png'
import SaoPaulo from '../../assets/img/destinations/sao-paulo2.png'
import RiodeJaneiro from '../../assets/img/destinations/rio-de-janeiro2.png'
import OuroPreto from '../../assets/img/destinations/ouro-preto2.png'
import Curitiba from '../../assets/img/destinations/curitiba2.png'
import Olinda from '../../assets/img/destinations/olinda2.png'
import Salvador from '../../assets/img/destinations/salvador2.png'

const coordinators = {
'latitude': -20.3861900,
'longitude': -43.5037300
}

type CoordinateData = {
  latitude: any;
  longitude: any;
}

function Result() {
	const location = useLocation()
	const [coordinates, setCoordinates] = useState<any>()
	const [latitude, setLatitude] = useState<number>()
	const [longitude, setLongitude] = useState<number>()
	const [queyResult, setQueryResult] = useState<any[]>([])
	const userData = getUserLocalStorage() != null ? getUserLocalStorage() : ''
	const navigate = useNavigate()
	
	const queryParams = new URLSearchParams(location.search);
	const id = queryParams.get('id');
  
	useEffect(() => {
		const headers = {
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json',
				'Authorization': 'Basic ' + btoa('admin:123'),
			}
		}

		setLatitude(-20.3861900)
		setLongitude(-43.5037300)
			
		axios.get('http://localhost:3000/roteiros/'+id, headers).then(response => {
			setQueryResult(response.data)
			console.log(response.data)
			/*
		  const coordinateslatlong = [
				{latitude: -20.3861900, longitude: -43.5037300}
			];	
			
			setCoordinates(coordinateslatlong)*/
		})
		
		
		
	}, []);

	
	function handleClick(){
		Alertify.alert('Reserva efetuada com sucesso!');
		//navigate('/me/booking')
	}
	
	
	  return (
		<div>
		  { userData.username ? <Navuser /> : <Navbar /> }
		  <div id='main'>
			<div className='w-100 top-internas'>
			  <h3 className='text-center fw-bold'>Pesquisa de roteiros</h3>
			  <div className='d-flex justify-content-center'>
				<nav aria-label='breadcrumb'>
				  <ol className='breadcrumb'>
					<li className='breadcrumb-item'>
					  <a href='/'>Home</a>
					</li>
					<li className='breadcrumb-item active' aria-current='page'>
					  Pesquisa de roteiros
					</li>
				  </ol>
				</nav>
			  </div>
			</div>

			<div className='container'>
			  <div className='row'>
				<div className='col-md-12 col-sm-12'>
				  <div className='rounded-4 p-5 mb-5 destination-details'>
					<h3 className='h3 fw-bold'>{queyResult?.map((item) => item.cidade.name)}</h3>
					<p>{''}</p>

					<div className='row mb-4'>
					  <div className='col-md-6'>
						{/*{queyResult?.map((item) => (

						))}*/}
				
						<div
						  id='carousel-destination'
						  className='carousel slide'
						  data-bs-ride='carousel'
						>
						  <div className='carousel-indicators'>
							<button
							  type='button'
							  data-bs-target='#carousel-destination'
							  data-bs-slide-to='0'
							  className='active'
							  aria-current='true'
							  aria-label='Slide 1'
							></button>
	
						  </div>
						  <div className='carousel-inner'>
							<img
								src={OuroPreto}
								className='d-block w-100 rounded-4'
								alt='Ouro Preto'
							  />

							

						  </div>
						</div>
					  </div>
					  <div className='col-md-6'>
						{queyResult?.map((item) => (
							<MapContainer center={[item.cidade.latitude, item.cidade.longitude]} zoom={12} scrollWheelZoom={false} key={item.idRoteiro}>
								<TileLayer
								attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
								url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
								/>
								<Marker position={[item.cidade.latitude, item.cidade.longitude]} icon={new Icon({iconUrl: markerIconPng, iconSize: [25, 41], iconAnchor: [12, 41]})}>
									<Popup>
										<p>{item.cidade.description}</p>
									</Popup>
								</Marker>						
							</MapContainer>
						))}
					  </div>
					</div>

					{queyResult?.map((item) => (
						<div key={item.idRoteiro}>
							<p className="mb-3">{item.cidade.description}</p>
							
							<p className="mb-1"><span className="btn btn-secondary rounded-5"><i className="bi bi-calendar3"></i> {item.days} dias</span> <span className="btn btn-secondary rounded-5"><i className="bi bi-cash-coin"></i> A partir de <strong>R$ {item.valor}</strong></span></p>
							<p className="m-0">Latitude: {item.cidade.latitude} Longitude: {item.cidade.longitude}</p>
							<p className="mb-3">Cadastrado por: Gilmar</p>
							
							{/*<a href={'book?id='+item.idRoteiro} className='btn btn-warning rounded-pill me-2 ps-4 pe-4'>
							  Fazer reserva
							</a>*/}
							<button type="button" className='btn btn-warning rounded-pill me-2 ps-4 pe-4' onClick={handleClick}>Fazer reserva</button>
						</div>
						))}

				  </div>

				  <div className='accordion mb-5 rounded-4' id='accordionExample'>
					<div className='accordion-item'>
					  <h2 className='accordion-header' id='headingOne'>
						<button
						  className='accordion-button collapsed'
						  type='button'
						  data-bs-toggle='collapse'
						  data-bs-target='#collapseOne'
						  aria-expanded='false'
						  aria-controls='collapseOne'
						>
						  <i className='bi bi-calendar2-event me-2'></i> Quando ir?
						</button>
					  </h2>
					  <div
						id='collapseOne'
						className='accordion-collapse collapse'
						aria-labelledby='headingOne'
						data-bs-parent='#accordionExample'
					  >
						<div className='accordion-body'>
						  <p>
							Ouro Preto é um cidade voltada para o turismo e durante todo o ano recebe
							visitantes. Os fins de semana são sempre mais disputados, especialmente pela
							presença dos turistas de cidades próximas, que buscam viagens rápidas. O
							mesmo acontece nos feriados e férias escolares, que sempre atraem mais
							visitantes. Se você deseja visitar a cidade com mais tranquilidade e sem
							pagar muito caro pela hospedagem, o ideal é fugir dos meses de dezembro,
							janeiro, fevereiro e julho, quando Ouro Preto é tomada por turistas.
						  </p>

						  <p>
							Entre os feriados que mais atraem visitantes para Ouro Preto estão: o
							Carnaval, um dos eventos mais famosos de Ouro Preto; a Semana Santa e o
							Corpus Cristhi, pelas festividades religiosas; e o 12 de outubro, data na
							qual é realizada a Festa do 12, onde ex-estudantes de Ouro Preto retornam à
							cidade e às repúblicas para comemorações. Sem esquecer, claro, do Natal e
							Ano Novo. Em todos esses períodos, assim como nas férias escolares, o preço
							das hospedagens sobe consideravelmente e a viagem pode ficar bem mais cara.
						  </p>
						</div>
					  </div>
					</div>
					<div className='accordion-item'>
					  <h2 className='accordion-header' id='headingTwo'>
						<button
						  className='accordion-button collapsed'
						  type='button'
						  data-bs-toggle='collapse'
						  data-bs-target='#collapseTwo'
						  aria-expanded='false'
						  aria-controls='collapseTwo'
						>
						  <i className='bi bi-compass me-2'></i> Como chegar?
						</button>
					  </h2>
					  <div
						id='collapseTwo'
						className='accordion-collapse collapse'
						aria-labelledby='headingTwo'
						data-bs-parent='#accordionExample'
					  >
						<div className='accordion-body'>
						  <p>
							A cidade de Ouro Preto está localizada no estado de Minas Gerais, a apenas
							100 km da capital Belo Horizonte. Ouro Preto é um destino tranquilo de ser
							visitado, mesmo para quem busca um passeio de apenas um dia. A partir de BH,
							há várias opções de transportes e excursões para Ouro Preto. Até mesmo táxi
							e Uber fazem o trajeto até a cidade histórica. Por isso, não deixe de
							visitar Ouro Preto, mesmo que seja para um bate e volta.
						  </p>

						  <p>
							A principal porta de entrada para quem chega de outros estados é o Aeroporto
							Internacional de Belo Horizonte - Confins. Ele é o aeroporto mais próximo de
							Ouro Preto e recebe voos de todas as regiões do Brasil. Não há aeroportos em
							Ouro Preto. A partir de Confins, é necessário escolher a melhor opção para
							ir até Ouro Preto por via terrestre.
						  </p>
						</div>
					  </div>
					</div>
					<div className='accordion-item'>
					  <h2 className='accordion-header' id='headingThree'>
						<button
						  className='accordion-button collapsed'
						  type='button'
						  data-bs-toggle='collapse'
						  data-bs-target='#collapseThree'
						  aria-expanded='false'
						  aria-controls='collapseThree'
						>
						  <i className='bi bi-pin-map me-2'></i> Onde ficar?
						</button>
					  </h2>
					  <div
						id='collapseThree'
						className='accordion-collapse collapse'
						aria-labelledby='headingThree'
						data-bs-parent='#accordionExample'
					  >
						<div className='accordion-body'>
						  <p>
							Os turistas que chegarem a Ouro Preto encontrarão muitas opções de
							hospedagem para os dias de viagem. Há um grande número de hotéis, pousadas e
							hostels que são capazes de suprir bem a necessidade de todo tipo de
							viajante. Os preços, no entanto, podem não agradar à primeira vista. A
							cidade, totalmente voltada para o turismo, costuma ter diárias bem salgadas,
							especialmente nos fins de semana, feriados prolongados e férias escolares.
							Por isso, se quiser viajar para Ouro Preto, é recomendável se organizar com
							antecedência para não pagar muito caro. Claro que também há opções mais
							baratas, mas como resistir ao charme dos quartos nos casarões coloniais ou
							com bela vista para as igrejas da cidade? Se o dinheiro permitir, invista em
							hotéis que oferecem um pouco da história de Ouro Preto aliados a conforto e
							charme.{' '}
						  </p>
						</div>
					  </div>
					</div>
					<div className='accordion-item'>
					  <h2 className='accordion-header' id='headingFour'>
						<button
						  className='accordion-button collapsed'
						  type='button'
						  data-bs-toggle='collapse'
						  data-bs-target='#collapseFour'
						  aria-expanded='false'
						  aria-controls='collapseFour'
						>
						  <i className='bi bi-shop me-2'></i> Onde comer?
						</button>
					  </h2>
					  <div
						id='collapseFour'
						className='accordion-collapse collapse'
						aria-labelledby='headingFour'
						data-bs-parent='#accordionExample'
					  >
						<div className='accordion-body'>
						  <p>
							A especialidade culinária de Ouro Preto não poderia ser outra que não os
							maravilhosos temperos e sabores mineiros. Há boa oferta de restaurantes que
							servem os típicos lombo com tutu, frango com quiabo, costelinha, feijão
							tropeiro e galinha ao molho pardo. Não será difícil se deliciar entre a
							intensidade da comida mineira. Os pratos típicos poderão ser degustados em
							lanchonetes populares que servem PFs ou em restaurantes mais refinados com
							cardápios que mesclam a culinária mineira aos sabores internacionais. Os
							preços agradam a todos os bolsos.
						  </p>
						</div>
					  </div>
					</div>
					<div className='accordion-item'>
					  <h2 className='accordion-header' id='headingFive'>
						<button
						  className='accordion-button collapsed'
						  type='button'
						  data-bs-toggle='collapse'
						  data-bs-target='#collapseFive'
						  aria-expanded='false'
						  aria-controls='collapseFive'
						>
						  <i className='bi bi-ticket me-2'></i> O que fazer?
						</button>
					  </h2>
					  <div
						id='collapseFive'
						className='accordion-collapse collapse'
						aria-labelledby='headingFive'
						data-bs-parent='#accordionExample'
					  >
						<div className='accordion-body'>
						  <p>
							Ouro Preto consegue manter os viajantes que chegam à cidade entretidos por
							muitos dias. São dezenas de pontos turísticos a serem visitados, belas
							cidades nas redondezas para passeios de bate e volta, muitos mirantes que
							merecem paradas fotográficas e, claro, incontáveis comidinhas mineiras a
							serem experimentadas. Faltará tempo para tantas atrações. Caso você esteja
							organizando uma viagem curta, de apenas um final de semana, o melhor é focar
							no essencial de Ouro Preto para não ficar perdido entre tantas igrejas,
							museus, minas e povoados encantadores. Caso tenha mais tempo, aproveite para
							conhecer a arte e arquitetura de Ouro Preto por dentro, não apenas as
							fachadas. A paisagem de Ouro Preto é deslumbrante, mas é no interior das
							igrejas e casarões que estão alguns dos maiores tesouros locais.
						  </p>
						</div>
					  </div>
					</div>
				  </div>

				  <div id='comment-area' className='mb-5'>
					<div id='comment-list' className='mb-3'>
					  <div className='comment-item'>
						<div className='list-group w-auto'>
						  <div className='list-group-item list-group-item-action d-flex gap-3 py-3 mb-3 border-0 rounded-4'>
							<img
							  src={profilePic}
							  className='rounded-circle flex-shrink-0'
							  alt='Foto de perfil'
							  width='75'
							  height='75'
							/>
							<div className='d-flex gap-2 w-100 justify-content-between'>
							  <div>
								<p className='m-0'>
								  <strong>@gilmar</strong>
								</p>
								<p>
								  <small>13 de Abril de 2023</small>
								</p>
								<p>
								  <i className='bi bi-star-fill color'></i>
								  <i className='bi bi-star-fill color'></i>
								  <i className='bi bi-star-fill color'></i>
								  <i className='bi bi-star-fill color'></i>
								  <i className='bi bi-star-fill color'></i>
								</p>
								<p>
								  Ouro Preto é um museu a céu aberto,com suas Igrejas,morros,e muita história.Destaque para a Igreja de São Francisco de Assis e a casa dos contos.A sua universidade,construída um pouco á semelhança da universidade de Coimbra,Portugal,atrai estudantes de todo o Brasil.
Muitas pousadas onde se hospedar,bem como hotéis e restaurantes.O carnaval de Ouro Preto é também um evento que aconselho vivamente.
								</p>
							  </div>
							</div>
						  </div>
						  <div className='list-group-item list-group-item-action d-flex gap-3 py-3 mb-3 border-0 rounded-4'>
							<img
							  src={profilePic}
							  className='rounded-circle flex-shrink-0'
							  alt='Foto de perfil'
							  width='75'
							  height='75'
							/>
							<div className='d-flex gap-2 w-100 justify-content-between'>
							  <div>
								<p className='m-0'>
								  <strong>@doug</strong>
								</p>
								<p>
								  <small>10 de Abril de 2023</small>
								</p>
								<p>
								  <i className='bi bi-star-fill color'></i>
								  <i className='bi bi-star-fill color'></i>
								  <i className='bi bi-star-fill'></i>
								  <i className='bi bi-star-fill'></i>
								  <i className='bi bi-star-fill'></i>
								</p>
								<p>
								  Ouro Preto, é quase o oposto de Tiradentes. Transito complicado, cheguei bem no horário de pico e mesmo para um cidade pequena o transito é caótico, ainda mais quando recebe algum evento. Mas isso não é nada. Basta sair do carro para trabalhar as panturrilhas e ver o quanto a cidade é charmosa, e tamanha a beleza do lugar. O quanto de história essa cidade carrega. Adorei conhecer cada canto que fui. A casa do Aleijadinho, com cachaça de ouro, e muitos móveis antigos, alguns originais da própria casa. Restaurantes ótimos com comida caseira de fogão a lenha. Além de gostoso, lindo! Viajar para Ouro

Para Ouro Preto foi para mim uma experiência memorável.
								</p>
							  </div>
							</div>
						  </div>
						</div>
					  </div>
					</div>

					<div className='text-end'>
					  <button className='btn btn-light rounded-5 mb-3'>
						Mais avaliações <i className='bi bi-chevron-right'></i>
					  </button>
					</div>

					<div id='comment-form' className='rounded-4'>
					  <form className='row g-3'>
						<div className='col-12'>
						  <label htmlFor='msg' className='form-label' style={{ fontSize: '22px' }}>
							Deixe um comentário
						  </label>
						  <textarea className='form-control' id='msg' rows={3}></textarea>
						</div>

						<div className='col-12' id='rating'>
						  Sua avaliação
						  <input
							type='checkbox'
							className='btn-check'
							name='rating'
							id='star1'
							autoComplete='off'
						  />
						  <label className='btn btn-outline-light' htmlFor='star1'>
							<i className='bi bi-star-fill'></i>
						  </label>
						  <input
							type='checkbox'
							className='btn-check'
							name='rating'
							id='star2'
							autoComplete='off'
						  />
						  <label className='btn btn-outline-light' htmlFor='star2'>
							<i className='bi bi-star-fill'></i>
						  </label>
						  <input
							type='checkbox'
							className='btn-check'
							name='rating'
							id='star3'
							autoComplete='off'
						  />
						  <label className='btn btn-outline-light' htmlFor='star3'>
							<i className='bi bi-star-fill'></i>
						  </label>
						  <input
							type='checkbox'
							className='btn-check'
							name='rating'
							id='star4'
							autoComplete='off'
						  />
						  <label className='btn btn-outline-light' htmlFor='star4'>
							<i className='bi bi-star-fill'></i>
						  </label>
						  <input
							type='checkbox'
							className='btn-check'
							name='rating'
							id='star5'
							autoComplete='off'
						  />
						  <label className='btn btn-outline-light' htmlFor='star5'>
							<i className='bi bi-star-fill'></i>
						  </label>
						</div>
						<div className='col-12'>
						  <button
							type='submit'
							className='btn btn-warning rounded-5 ps-3 pe-3 float-end'
						  >
							Enviar comentário
						  </button>
						</div>
					  </form>
					</div>
				  </div>
				</div>
			  </div>
			</div>
		  </div>
		  <Footer />
		</div>
	  )
}

export default Result;