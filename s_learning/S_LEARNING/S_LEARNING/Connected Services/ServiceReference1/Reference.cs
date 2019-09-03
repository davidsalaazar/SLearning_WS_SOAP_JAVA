//------------------------------------------------------------------------------
// <generado automáticamente>
//     Este código fue generado por una herramienta.
//     //
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </generado automáticamente>
//------------------------------------------------------------------------------

namespace ServiceReference1
{
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("dotnet-svcutil", "1.0.0.1")]
    [System.ServiceModel.ServiceContractAttribute(Namespace="http://servidor.utng.com/", ConfigurationName="ServiceReference1.Servidor")]
    public interface Servidor
    {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://servidor.utng.com/Servidor/helloWorldRequest", ReplyAction="http://servidor.utng.com/Servidor/helloWorldResponse")]
        System.Threading.Tasks.Task<ServiceReference1.helloWorldResponse> helloWorldAsync(ServiceReference1.helloWorldRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://servidor.utng.com/Servidor/getLoginRequest", ReplyAction="http://servidor.utng.com/Servidor/getLoginResponse")]
        System.Threading.Tasks.Task<ServiceReference1.getLoginResponse> getLoginAsync(ServiceReference1.getLoginRequest request);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("dotnet-svcutil", "1.0.0.1")]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class helloWorldRequest
    {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="helloWorld", Namespace="http://servidor.utng.com/", Order=0)]
        public ServiceReference1.helloWorldRequestBody Body;
        
        public helloWorldRequest()
        {
        }
        
        public helloWorldRequest(ServiceReference1.helloWorldRequestBody Body)
        {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("dotnet-svcutil", "1.0.0.1")]
    [System.Runtime.Serialization.DataContractAttribute()]
    public partial class helloWorldRequestBody
    {
        
        public helloWorldRequestBody()
        {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("dotnet-svcutil", "1.0.0.1")]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class helloWorldResponse
    {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="helloWorldResponse", Namespace="http://servidor.utng.com/", Order=0)]
        public ServiceReference1.helloWorldResponseBody Body;
        
        public helloWorldResponse()
        {
        }
        
        public helloWorldResponse(ServiceReference1.helloWorldResponseBody Body)
        {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("dotnet-svcutil", "1.0.0.1")]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="")]
    public partial class helloWorldResponseBody
    {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public string @return;
        
        public helloWorldResponseBody()
        {
        }
        
        public helloWorldResponseBody(string @return)
        {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("dotnet-svcutil", "1.0.0.1")]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class getLoginRequest
    {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="getLogin", Namespace="http://servidor.utng.com/", Order=0)]
        public ServiceReference1.getLoginRequestBody Body;
        
        public getLoginRequest()
        {
        }
        
        public getLoginRequest(ServiceReference1.getLoginRequestBody Body)
        {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("dotnet-svcutil", "1.0.0.1")]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="")]
    public partial class getLoginRequestBody
    {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public string arg0;
        
        public getLoginRequestBody()
        {
        }
        
        public getLoginRequestBody(string arg0)
        {
            this.arg0 = arg0;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("dotnet-svcutil", "1.0.0.1")]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class getLoginResponse
    {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="getLoginResponse", Namespace="http://servidor.utng.com/", Order=0)]
        public ServiceReference1.getLoginResponseBody Body;
        
        public getLoginResponse()
        {
        }
        
        public getLoginResponse(ServiceReference1.getLoginResponseBody Body)
        {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("dotnet-svcutil", "1.0.0.1")]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="")]
    public partial class getLoginResponseBody
    {
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=0)]
        public bool @return;
        
        public getLoginResponseBody()
        {
        }
        
        public getLoginResponseBody(bool @return)
        {
            this.@return = @return;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("dotnet-svcutil", "1.0.0.1")]
    public interface ServidorChannel : ServiceReference1.Servidor, System.ServiceModel.IClientChannel
    {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("dotnet-svcutil", "1.0.0.1")]
    public partial class ServidorClient : System.ServiceModel.ClientBase<ServiceReference1.Servidor>, ServiceReference1.Servidor
    {
        
    /// <summary>
    /// Implemente este método parcial para configurar el punto de conexión de servicio.
    /// </summary>
    /// <param name="serviceEndpoint">El punto de conexión para configurar</param>
    /// <param name="clientCredentials">Credenciales de cliente</param>
    static partial void ConfigureEndpoint(System.ServiceModel.Description.ServiceEndpoint serviceEndpoint, System.ServiceModel.Description.ClientCredentials clientCredentials);
        
        public ServidorClient() : 
                base(ServidorClient.GetDefaultBinding(), ServidorClient.GetDefaultEndpointAddress())
        {
            this.Endpoint.Name = EndpointConfiguration.ServidorPort.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public ServidorClient(EndpointConfiguration endpointConfiguration) : 
                base(ServidorClient.GetBindingForEndpoint(endpointConfiguration), ServidorClient.GetEndpointAddress(endpointConfiguration))
        {
            this.Endpoint.Name = endpointConfiguration.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public ServidorClient(EndpointConfiguration endpointConfiguration, string remoteAddress) : 
                base(ServidorClient.GetBindingForEndpoint(endpointConfiguration), new System.ServiceModel.EndpointAddress(remoteAddress))
        {
            this.Endpoint.Name = endpointConfiguration.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public ServidorClient(EndpointConfiguration endpointConfiguration, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(ServidorClient.GetBindingForEndpoint(endpointConfiguration), remoteAddress)
        {
            this.Endpoint.Name = endpointConfiguration.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public ServidorClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress)
        {
        }
        
        public System.Threading.Tasks.Task<ServiceReference1.helloWorldResponse> helloWorldAsync(ServiceReference1.helloWorldRequest request)
        {
            return base.Channel.helloWorldAsync(request);
        }
        
        public System.Threading.Tasks.Task<ServiceReference1.getLoginResponse> getLoginAsync(ServiceReference1.getLoginRequest request)
        {
            return base.Channel.getLoginAsync(request);
        }
        
        public virtual System.Threading.Tasks.Task OpenAsync()
        {
            return System.Threading.Tasks.Task.Factory.FromAsync(((System.ServiceModel.ICommunicationObject)(this)).BeginOpen(null, null), new System.Action<System.IAsyncResult>(((System.ServiceModel.ICommunicationObject)(this)).EndOpen));
        }
        
        public virtual System.Threading.Tasks.Task CloseAsync()
        {
            return System.Threading.Tasks.Task.Factory.FromAsync(((System.ServiceModel.ICommunicationObject)(this)).BeginClose(null, null), new System.Action<System.IAsyncResult>(((System.ServiceModel.ICommunicationObject)(this)).EndClose));
        }
        
        private static System.ServiceModel.Channels.Binding GetBindingForEndpoint(EndpointConfiguration endpointConfiguration)
        {
            if ((endpointConfiguration == EndpointConfiguration.ServidorPort))
            {
                System.ServiceModel.BasicHttpBinding result = new System.ServiceModel.BasicHttpBinding();
                result.MaxBufferSize = int.MaxValue;
                result.ReaderQuotas = System.Xml.XmlDictionaryReaderQuotas.Max;
                result.MaxReceivedMessageSize = int.MaxValue;
                result.AllowCookies = true;
                return result;
            }
            throw new System.InvalidOperationException(string.Format("No se pudo encontrar un punto de conexión con el nombre \"{0}\".", endpointConfiguration));
        }
        
        private static System.ServiceModel.EndpointAddress GetEndpointAddress(EndpointConfiguration endpointConfiguration)
        {
            if ((endpointConfiguration == EndpointConfiguration.ServidorPort))
            {
                return new System.ServiceModel.EndpointAddress("http://192.168.0.12:8080/SLearningWS/slearningWS");
            }
            throw new System.InvalidOperationException(string.Format("No se pudo encontrar un punto de conexión con el nombre \"{0}\".", endpointConfiguration));
        }
        
        private static System.ServiceModel.Channels.Binding GetDefaultBinding()
        {
            return ServidorClient.GetBindingForEndpoint(EndpointConfiguration.ServidorPort);
        }
        
        private static System.ServiceModel.EndpointAddress GetDefaultEndpointAddress()
        {
            return ServidorClient.GetEndpointAddress(EndpointConfiguration.ServidorPort);
        }
        
        public enum EndpointConfiguration
        {
            
            ServidorPort,
        }
    }
}
