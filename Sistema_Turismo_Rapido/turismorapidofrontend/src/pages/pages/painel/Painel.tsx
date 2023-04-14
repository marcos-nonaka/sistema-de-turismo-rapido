import React from 'react'
import { NavbarPainel } from '../../components'

//import '../../assets/css/signup-login.css';
//import '../../assets/css/login.css';

import ProfilePic from '../../assets/img/profile_pic2.jpg'

function Painel() {
  return (
    <>
      <NavbarPainel />
      <div id='main'>
        <div className='container mt-5'>
          <div className='row'>
            <div className='col-md-3 col-sm-12 pt-5'>
              <div className='rounded-4 bg-white p-4'>
                <div className=' text-center mb-5'>
                  <img
                    className='avatar-img rounded-circle'
                    src={ProfilePic}
                    alt='avatar'
                    style={{ width: '5.1rem' }}
                  />
                  <p className='m-0'>
                    <strong>Pedro de Alcântara...</strong>
                  </p>
                  <p className='small m-0'>pedro@palacio.imp.br</p>
                </div>

                <ul className='nav flex-column'>
                  <li className='nav-item'>
                    <a className='nav-link' href='#'>
                      <i className='bi bi-trash3'></i> Excluir cadastro
                    </a>
                  </li>
                  <li className='nav-item'>
                    <a className='nav-link' href='#'>
                      <i className='bi bi-power fa-fw me-2'></i> Logout
                    </a>
                  </li>
                </ul>
              </div>
            </div>
            <div className='col-md-9 col-sm-12 pt-5'>
              <div className='rounded-4 bg-white p-5'>
                <h2 className='h2 fw-bold mb-4'>Bem-vindo</h2>

                <p className='m-0'>
                  <small>E-mail da conta</small>
                </p>
                <p className='fw-bold mb-5'>pedro@palacio.imp.br</p>

                <ul className='nav nav-tabs' id='myTab' role='tablist'>
                  <li className='nav-item' role='presentation'>
                    <button
                      className='nav-link active'
                      id='account-tab'
                      data-bs-toggle='tab'
                      data-bs-target='#account-tab-pane'
                      type='button'
                      role='tab'
                      aria-controls='account-tab-pane'
                      aria-selected='true'
                    >
                      Minha conta
                    </button>
                  </li>
                  <li className='nav-item' role='presentation'>
                    <button
                      className='nav-link'
                      id='reservation-tab'
                      data-bs-toggle='tab'
                      data-bs-target='#reservation-tab-pane'
                      type='button'
                      role='tab'
                      aria-controls='reservation-tab-pane'
                      aria-selected='false'
                    >
                      Minhas reservas
                    </button>
                  </li>
                  <li className='nav-item' role='presentation'>
                    <button
                      className='nav-link'
                      id='disabled-tab'
                      data-bs-toggle='tab'
                      data-bs-target='#disabled-tab-pane'
                      type='button'
                      role='tab'
                      aria-controls='disabled-tab-pane'
                      aria-selected='false'
                      disabled
                    >
                      Formas de pagamento
                    </button>
                  </li>
                </ul>
                <div className='tab-content' id='tabContent'>
                  <div
                    className='tab-pane fade show active'
                    id='account-tab-pane'
                    role='tabpanel'
                    aria-labelledby='account-tab'
                  >
                    <form className='row g-3 mt-2'>
                      <div className='col-md-6'>
                        <label htmlFor='username' className='form-label'>
                          Usuário
                        </label>
                        <input
                          type='text'
                          className='form-control'
                          id='username'
                          value='pedro_imperador'
                        />
                      </div>
                      <div className='col-md-6'>
                        <label htmlFor='password' className='form-label'>
                          Senha
                        </label>
                        <input
                          type='password'
                          className='form-control'
                          id='password'
                          value='123456'
                        />
                      </div>
                      <div className='col-md-8'>
                        <label htmlFor='name' className='form-label'>
                          Nome
                        </label>
                        <input
                          type='text'
                          className='form-control'
                          id='name'
                          value='Pedro de Alcântara de Bragança e Bourbon'
                        />
                      </div>
                      <div className='col-md-4'>
                        <label htmlFor='cpf' className='form-label'>
                          CPF
                        </label>
                        <input
                          type='text'
                          className='form-control'
                          id='cpf'
                          value='999.999.999-99'
                        />
                      </div>

                      <div className='col-md-3'>
                        <label htmlFor='birthdate' className='form-label'>
                          Data nasc.
                        </label>
                        <input
                          type='text'
                          className='form-control'
                          id='birthdate'
                          value='12/10/1798'
                        />
                      </div>
                      <div className='col-md-3'>
                        <label htmlFor='phone' className='form-label'>
                          Telefone
                        </label>
                        <input
                          type='text'
                          className='form-control'
                          id='phone'
                          value='+55 (21) 99999-9999'
                        />
                      </div>
                      <div className='col-md-6'>
                        <label htmlFor='email' className='form-label'>
                          E-mail
                        </label>
                        <input
                          type='email'
                          className='form-control'
                          id='email'
                          value='pedro@palacio.imp.br'
                        />
                      </div>

                      <div className='col-12'>
                        <button
                          type='submit'
                          className='btn btn-warning rounded-5 ps-3 pe-3 float-end'
                        >
                          Alterar cadastro
                        </button>
                      </div>
                    </form>
                  </div>
                  <div
                    className='tab-pane fade p-4'
                    id='reservation-tab-pane'
                    role='tabpanel'
                    aria-labelledby='reservation-tab'
                  >
                    Minhas reservas
                  </div>
                  <div
                    className='tab-pane fade'
                    id='disabled-tab-pane'
                    role='tabpanel'
                    aria-labelledby='disabled-tab'
                  ></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default Painel