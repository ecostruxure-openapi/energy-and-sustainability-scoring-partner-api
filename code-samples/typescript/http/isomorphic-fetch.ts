import {HttpLibrary, RequestContext, ResponseContext} from './http';
import { from, Observable } from '../rxjsStub';
import axios from 'axios';


export class IsomorphicFetchHttpLibrary implements HttpLibrary {

    public send(request: RequestContext): Observable<ResponseContext> {
        let method = request.getHttpMethod().toString();
        let body = request.getBody();

        return from<Promise<ResponseContext>>(axios.get(request.getUrl(), {
            headers: request.getHeaders()
        }));
    }
}
