require 'will_paginate/view_helpers/action_view'

class SiteLinkRenderer < WillPaginate::ActionView::LinkRenderer
  protected

  def html_container(html)
    class_name = [container_attributes[:class], "pagination", "justify-content-center"].compact.join(" ");
    tag(:div, tag(:ul, html, :class => "pagination"), :class => class_name) 
  end

  def page_number(page)
    aria_label = @template.will_paginate_translate(:page_aria_label, :page => page.to_i) { "Page #{page}" }
    list_item_class = (page == current_page) ? "active page-item" : "page-item";
    tag(:li, link(page, page, :rel => rel_value(page), :"aria-label" => aria_label, :class => "page-link"), :class => list_item_class)
  end

  def gap
    tag(:li, link('&hellip;'.html_safe, '#', :class => "page-link"), :class => "page-item disabled")
  end

  def previous_or_next_page(page, text, classname)   
    link_class = page ? "#{classname} page-item" : "#{classname} page-item disabled"
    if page
      tag(:li, link(text, page, :class => "page-link"), :class => link_class)
    else
      tag(:li, link(text, "#", :class => "page-link", :"tabindex" => "-1"), :class => link_class)
    end
  end

end