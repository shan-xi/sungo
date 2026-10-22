export type Product = { id:number; name:string; category:string; description:string; imageUrl:string; code:string; published:boolean; sortOrder:number };
export type NewsArticle = { id:number; title:string; summary:string; content:string; imageUrl:string; publishedDate:string; published:boolean };
export type Inquiry = { id:number; name:string; email:string; phone:string; company:string; message:string; status:'NEW'|'IN_PROGRESS'|'CLOSED'; createdAt:string };
export type Settings = Record<string,string>;
