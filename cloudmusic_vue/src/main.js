import Vue from 'vue'
import App from './App.vue'

import router from './router';
import store from './store';

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// import locale from 'elementui/lib/locale/lang/zh-CN';
// Vue.use(ElementUI, { locale, size: 'small'})
Vue.use(ElementUI)

import '@/permission';
import '@/styles/index.scss';
import { postRequest } from '@/utils/request';
import { postService } from '@/utils/service';
import { undeveloped, noUserLogin } from '@/utils/tools';

Vue.prototype.$postRequest = postRequest
Vue.prototype.$postService = postService
Vue.prototype.$undeveloped = undeveloped
Vue.prototype.$noUserLogin = noUserLogin

Vue.config.productionTip = false
new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
