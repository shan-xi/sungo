import type { Product, NewsArticle, Inquiry, Settings } from './types';
const base='/api';
export function token(){return localStorage.getItem('sungo_admin_token')||'';}
async function request<T>(path:string,init:RequestInit={}):Promise<T>{const headers=new Headers(init.headers);if(init.body && !(init.body instanceof FormData))headers.set('Content-Type','application/json');if(token())headers.set('Authorization',`Bearer ${token()}`);const res=await fetch(base+path,{...init,headers});if(!res.ok){let message=`Request failed (${res.status})`;try{const body=await res.json();message=body.message||body.error||message;}catch{}throw new Error(message);}if(res.status===204)return undefined as T;return res.json() as Promise<T>;}
export const api={
 products:()=>request<Product[]>('/public/products'), news:()=>request<NewsArticle[]>('/public/news'), settings:()=>request<Settings>('/public/settings'),
 inquiry:(data:Record<string,string>)=>request<{message:string}>('/public/inquiries',{method:'POST',body:JSON.stringify(data)}),
 login:(username:string,password:string)=>request<{token:string;username:string}>('/auth/login',{method:'POST',body:JSON.stringify({username,password})}),
 adminProducts:()=>request<Product[]>('/admin/products'), saveProduct:(p:Partial<Product>)=>request<Product>(p.id?`/admin/products/${p.id}`:'/admin/products',{method:p.id?'PUT':'POST',body:JSON.stringify(p)}), deleteProduct:(id:number)=>request<void>(`/admin/products/${id}`,{method:'DELETE'}),
 adminNews:()=>request<NewsArticle[]>('/admin/news'), saveNews:(n:Partial<NewsArticle>)=>request<NewsArticle>(n.id?`/admin/news/${n.id}`:'/admin/news',{method:n.id?'PUT':'POST',body:JSON.stringify(n)}), deleteNews:(id:number)=>request<void>(`/admin/news/${id}`,{method:'DELETE'}),
 inquiries:()=>request<Inquiry[]>('/admin/inquiries'), inquiryStatus:(id:number,status:Inquiry['status'])=>request<Inquiry>(`/admin/inquiries/${id}/status`,{method:'PATCH',body:JSON.stringify({status})}),
 adminSettings:()=>request<Settings>('/admin/settings'), saveSettings:(s:Settings)=>request<Settings>('/admin/settings',{method:'PUT',body:JSON.stringify(s)}),
 upload:async(file:File)=>{const fd=new FormData();fd.append('file',file);return request<{url:string}>('/admin/uploads',{method:'POST',body:fd});}
};
