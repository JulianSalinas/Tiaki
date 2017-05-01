using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Servicio.Controllers
{
    public class Conector
    {

        private static LinqDataContext Linq;

        public static LinqDataContext getLinqContext() {
            if (Linq == null) Linq = new LinqDataContext();
            return Linq;
        }

    }
}