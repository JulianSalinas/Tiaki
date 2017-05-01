using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Servicio.Models
{
    public class Vigilante
    {

        private string _id;
        private string _nombre;
        private string _telefono;
        private string _civil;
        private string _estado;
        private string _grupo;
        private Residencial _residencial;
        private float _precioHora;
        private float _extraHora;
        private int _horasTrabajadas;
        private int _extrasTrabajadas;

        public string Id
        {
            get
            {
                return _id;
            }

            set
            {
                _id = value;
            }
        }

        public string Nombre
        {
            get
            {
                return _nombre;
            }

            set
            {
                _nombre = value;
            }
        }

        public string Telefono
        {
            get
            {
                return _telefono;
            }

            set
            {
                _telefono = value;
            }
        }

        public string Civil
        {
            get
            {
                return _civil;
            }

            set
            {
                _civil = value;
            }
        }

        public string Estado
        {
            get
            {
                return _estado;
            }

            set
            {
                _estado = value;
            }
        }

        public string Grupo
        {
            get
            {
                return _grupo;
            }

            set
            {
                _grupo = value;
            }
        }

        public Residencial Residencial
        {
            get
            {
                return _residencial;
            }

            set
            {
                _residencial = value;
            }
        }

        public float PrecioHora
        {
            get
            {
                return _precioHora;
            }

            set
            {
                _precioHora = value;
            }
        }

        public float ExtraHora
        {
            get
            {
                return _extraHora;
            }

            set
            {
                _extraHora = value;
            }
        }

        public int HorasTrabajadas
        {
            get
            {
                return _horasTrabajadas;
            }

            set
            {
                _horasTrabajadas = value;
            }
        }

        public int ExtrasTrabajadas
        {
            get
            {
                return _extrasTrabajadas;
            }

            set
            {
                _extrasTrabajadas = value;
            }
        }
    }
}