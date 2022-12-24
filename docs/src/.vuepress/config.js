const { description } = require('../../package')

module.exports = {
  base: '/java_backend/',
  /**
   * Ref：https://v1.vuepress.vuejs.org/config/#title
   */
  title: 'Java backend Study',
  /**
   * Ref：https://v1.vuepress.vuejs.org/config/#description
   */
  description: description,

  /**
   * Extra tags to be injected to the page HTML `<head>`
   *
   * ref：https://v1.vuepress.vuejs.org/config/#head
   */
  head: [
    ['meta', { name: 'theme-color', content: '#3eaf7c' }],
    ['meta', { name: 'apple-mobile-web-app-capable', content: 'yes' }],
    ['meta', { name: 'apple-mobile-web-app-status-bar-style', content: 'black' }]
  ],

  /**
   * Theme configuration, here is the default theme configuration for VuePress.
   *
   * ref：https://v1.vuepress.vuejs.org/theme/default-theme-config.html
   */
  themeConfig: {
    repo: '',
    editLinks: false,
    docsDir: '',
    editLinkText: '',
    lastUpdated: false,
    nav: [
      {
        text: 'Basic',
        link: '/java_basic/',
      },
      {
        text: 'Advanced',
        link: '/java_advanced/'
      },
      {
        text: 'Build Tools',
        link: '/tools/'
      },
      {
        text: 'Spring Framework',
        link: '/spring/'
      },
      {
        text: 'ORM',
        link: '/ORM/'
      },
      {
        text: 'Testing',
        link: '/testing/'
      }
    ],
    sidebar: {
      '/java_basic/': [
        {
          title: 'Java',
          collapsable: true,
          children: [
            '',
          ]
        },
        {
          title: '변수와 타입',
          collapsable: true,
          children: [
            '/java_basic/Chapter_1/',
          ]
        },
        {
          title: '연산자',
          children: [
            '/java_basic/Chapter_2/'
          ]
        },
        {
          title: '조건문과 반복문',
          children: [
            '/java_basic/Chapter_3/'
          ]
        },
        {
          title: '객체지향 프로그래밍',
          collapsable: true,
          children: [
              '/java_basic/Chapter_4/',
              {
                title: '참조타입',
                collapsable: true,
                children : [
                  '/java_basic/Chapter_4/01_reference_type/01_concept/',
                ]
              },
              {
                title: '클래스',
                collapsable: true,
                children : [
                  '/java_basic/Chapter_4/02_class/01_concept/',
                ]
              },
              {
                title: '인터페이스',
                collapsable: true,
                children : [
                  '/java_basic/Chapter_4/03_interface/01_concept/',
                ]
              },
              {
                title: '익명클래스',
                collapsable: true,
                children : [
                  '/java_basic/Chapter_4/04_anonymous_object/01_concept/',
                ]
              },
          ]          
        },
        {
          title: '라이브러리와 모듈',
          children: [
            '/java_basic/Chapter_5/'
          ]
        },
        {
          title: '예외처리',
          children: [
            '/java_basic/Chapter_6/'
          ]
        },
        {
          title: '제네릭',
          children: [
            '/java_basic/Chapter_7/'
          ]
        },
        {
          title: '멀티스레드',
          children: [
            '/java_basic/Chapter_8/'
          ]
        },
        {
          title: '컬렉션 자료구조',
          children: [
            '/java_basic/Chapter_9/'
          ]
        },
        {
          title: 'Lambda',
          children: [
            '/java_basic/Chapter_10/'
          ]
        },
        {
          title: 'Stream',
          children: [
            '/java_basic/Chapter_11/'
          ]
        },
        {
          title: '데이터 I/O',
          children: [
            '/java_basic/Chapter_12/'
          ]
        },
        {
          title: '네트워크 I/O',
          children: [
            '/java_basic/Chapter_13/'
          ]
        },
        {
          title: '데이터베이스 I/O',
          children: [
            '/java_basic/Chapter_14/'
          ]
        },
      ],
      //////// Java 심화 ///////
      '/java_advanced/': [
        {
          title: 'Java',
          collapsable: true,
          children: [
            '',
            ['/java_advanced/Chapter_1/', 'Java'],
          ]
        }
      ],
    }
  },

  /**
   * Apply plugins，ref：https://v1.vuepress.vuejs.org/zh/plugin/
   */
  plugins: [
    '@vuepress/plugin-back-to-top',
    '@vuepress/plugin-medium-zoom',
  ]
}
